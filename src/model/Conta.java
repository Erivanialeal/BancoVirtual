package src.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    // atributos
    private String numero;
    private BigDecimal saldo;
    private Cliente titular;
    private StatusConta status;
    private List<Transacao> transacoes;

    public Conta(String numero, Cliente titular) {
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
        this.titular = titular;
        this.status = StatusConta.ATIVA;
        this.transacoes = new ArrayList<>();
    }

    public enum StatusConta {
        ATIVA,
        INATIVA,
        BLOQUEADA,
        ENCERRADA;

    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public StatusConta getStatus() {
        return status;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void setStatus(StatusConta status) {
        this.status = status;
    }

    // metado para validar valor de deposito
    public void validarValorDeposito(BigDecimal valor) {
        // indentificador de conta
        // status da conta
        if (status != StatusConta.ATIVA) {
            throw new IllegalStateException("Conta não está ativa");
        }
        // valor não pode ser nullo
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo");
        }
        // valor não pode ser menor que zero
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero!");
        }
        // validar as casas decimais
        if (valor.scale() > 2) {
            throw new IllegalArgumentException("Máxio duas casas decimais!");
        }
        // limitar o deposito
        if (valor.compareTo(RegrasBanco.LIMITE_DEPOSITO) > 0) {
            throw new IllegalArgumentException("Limite de depoisto atigindo!");
        }
        // registra transações

    }

    public void depositar(BigDecimal valor) {
        validarValorDeposito(valor);
        saldo = saldo.add(valor);
    }

    // metado para validar valor de saque
    public void validarValorSaque(BigDecimal valor) {
        // conta est ativa
        if (status != StatusConta.ATIVA) {
            throw new IllegalStateException("Conta não está ativa");
        }
        // valor não pode ser nullo
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo!");
        }
        // valor não pode ser maior que zero
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor não pode ser menor que zero");
        }
        // maximo duas casas decimais
        if (valor.scale() > 2) {
            throw new IllegalArgumentException("Maximo até duas casas decimais");

        }
        // saldo suficiente
        if (saldo.compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo abaixo de zero");

        }
        // limite de saque
        if (valor.compareTo(RegrasBanco.LIMITE_SAQUE_DIARIO) > 0) {
            throw new IllegalArgumentException("Valor excede o limite de saque");
        }

    }

    public void sacar(BigDecimal valor) {
        validarValorSaque(valor);
        saldo.subtract(valor);
    }

    public void validarValorTrasferencia(BigDecimal valor, Conta contaDestino) {
        // é nullo ou esta avazio
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nullo.");
        }
        // o valor é valido? precisa ser acima de zero
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo!");
        }
        // verificar se as conta de destino existe
        if (contaDestino == null) {
            throw new IllegalArgumentException(" Conta de destino não existe!");
        }
        // valor é suficiente
        if (this.saldo.compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        // evtar trasferencia a se mesmo
        if (this.equals(contaDestino)) {
            throw new IllegalArgumentException(" não se pode trasferir para a propia conta");
        }
        // garantir que o limite diario não seja ultrapassado
        if (valor.compareTo(RegrasBanco.LIMITE_TRASFERENCIA_DIARIO) > 0) {
            throw new IllegalArgumentException("Limite de trasferencia diaria atingida!");

        }
        // garantir que o valor tenha apenas duas casas decimais
        if (valor.scale() > 2) {
            throw new IllegalArgumentException("Maximo até duas casa decimais");
        }
        // validar se a trasferecia não foge do padrão do comportamento do cliente

    }

    public void trasferir(BigDecimal valor, Conta contaDestino) {
        // conta de destino está ativa
        if (contaDestino.getStatus() != StatusConta.ATIVA) {
            throw new IllegalArgumentException("A conta não está habita para receber trasferencia");

        }
        validarValorTrasferencia(valor, contaDestino);
        // efetivar trasferencia
        this.saldo = this.saldo.subtract(valor);
        // adicionar a conta destino
        contaDestino.saldo = contaDestino.saldo.add(valor);

        // criar um objeto para guarda o historico de transações
        Transacao transacao = new Transacao("TRANSFERENÇIA", valor, this.numero, contaDestino.numero);
        // adicionar ao historico da conta
        this.transacoes.add(transacao);

    }

}
