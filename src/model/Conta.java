package src.model;

import java.util.ArrayList;

public class Conta {

    private double saldo;
    private Cliente cliente;
    private int numeroConta;
    ArrayList<String> transacoes;

    public Conta(Cliente cliente, int numeroConta) {
        this.saldo = 0.0;
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.transacoes = new ArrayList<>();

    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            transacoes.add("Saque: - R$ " + valor);
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("Erro o valor do Deposito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        // valor inválido
        if (valor <= 0) {
            return;
        }
        // saldo insuficiente
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para essa operação.");
            return;
        }

        // saque autorizado
        this.saldo -= valor;
        this.transacoes.add("Saque: - R$ " + valor);

    }

    public double consultarSaldo() {
        // retornar saldo.
        return this.saldo;

    }

    public void extrato() {
        // retornar todas as transações
        System.out.println("------EXTRATO DA CONTA------");
        // Para cada String "T" dentro da lista de transações:
        for (String t : transacoes) {
            System.out.println(t); // im da vezprime a trasações

        }
        System.out.println("Saldo atual: R$ " + this.saldo);

    }

    public void registrarDeposito(double valor) {

    }

}
