package src.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    // a pasta model é onde fica as classes de dominios(entidade)
    // a pasta model é o sistema.
    // model não sabe como salvar buscar ou mostrar dados.
    private String nome;
    private String cpf;
    private String tipoCliente;
    private List<Conta> contas = new ArrayList<>();

    // .trim remove os espaços inuteis ex: transforma " " em ""
    // null verifica se a variavel é nula
    // isEmpty Verifica se , apos verificar os espaços sobrou algum caracter
    // regras de negocio o nome é obrigatorio
    public Cliente(String nome, String cpf, String tipoCliente) {
        if (nome == null || nome.trim().isEmpty()) {
            // valida nome
            throw new IllegalArgumentException("Nome é obrigatorio!");
        }
        // valida tipo de cliente
        if (tipoCliente == null || tipoCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de cliente é obrigatório");
        }
        if (!tipoCliente.equals("PF") && !tipoCliente.equals("PJ")) {
            throw new IllegalArgumentException("Tipo de cliente inválido. Use PF ou PJ.");
        }
        // valida CPF ou CNPJ conforme o tipo
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF/CNPJ é obrigatorio");

        }
        // valida tamnaho do documento conforme o tipo
        if (tipoCliente.equals("PF") && cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }

        if (tipoCliente.equals("PJ") && cpf.length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido. Deve conter 14 dígitos.");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

}
