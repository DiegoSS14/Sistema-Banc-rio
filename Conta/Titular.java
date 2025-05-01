package Exercicios.SistemaBancarioRefeito.Conta;

public class Titular {

    private String nome;
    private String cpf;

    Titular(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Criando geters e seters para fazer uso dos atributos privados da conta
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
