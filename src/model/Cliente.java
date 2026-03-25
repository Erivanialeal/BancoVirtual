package src.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {

    // atributos
    private String nome;
    private String cpf;
    private String email;
    private Map<String, Conta> Contas;

    // iniciar os atributos
    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.Contas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Map<String, Conta> geContas() {
        return Contas;
    }

    public String getEmail() {
        return email;
    }

    public String validarCpf() {
        if (getCpf() == null || getCpf().isEmpty()) {
            return "Erro: Cpf não pode ser vazio";
        }
        if (getCpf().length() != 11) {
            return "Erro: Cpf precisar ter 11 digitos";
        }
        return "Cpf: valido";
    }

    public String atualizarEmail(String novoEmail) {
        if (novoEmail == null || novoEmail.isEmpty()) {
            return "Erro: Email não pode ser vazio!";
        }
        if (!novoEmail.contains("@")) {
            return "Erro: Email precisa conter @";
        }
        this.email = novoEmail;
        return "Email atualizado com sucesso!";
    }

}
