package Exercicios.SistemaBancarioRefeito.Conta;

import java.util.Objects;

public class Conta {

    Titular titular;
    private double saldo;
    private String senha;

    Conta(Titular titular, double saldo, String senha) {
        this.titular = titular;
        this.saldo = saldo;
        this.senha = senha;
    }

    // Depositar
    public void depositar(double valor) {
        this.saldo += valor;
    }

    // Sacar
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado." + "\nSeu saldo atual é de R$ " + this.saldo);
        } else System.out.println("Sua conta não tem saldo suficiente.");
    }

    // Transferir
    public void transferir(double valor, Conta outraConta) {

        if (valor <= this.saldo) {
            this.saldo -= valor;
            outraConta.saldo += valor;
            System.out.println("Transferência realizada.");
        } else System.out.println("Sua conta não tem saldo suficiente.");
    }

    // Criando geters e seters para fazer uso dos atributos privados da conta
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
