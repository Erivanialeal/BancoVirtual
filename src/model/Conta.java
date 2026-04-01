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

}
