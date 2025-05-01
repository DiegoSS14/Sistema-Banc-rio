package Exercicios.SistemaBancarioRefeito.Conta;

import java.util.ArrayList;
import java.util.List;

public class Login {

    Conta conta;
    boolean logado = false;
    public String senhaDigitada;
    public String cpfDigitado;

    public static Conta contaLogada;

    // Menu Home
    public static List<String> MENU_HOME = List.of(
            "Entrar com CPF", "Encerrar programa"
    );

    // Menu Logado
    public static List<String> MENU_LOGADO = List.of(
            "Sacar", "Transferir", "Depositar", "Deslogar"
    );

    // Definindo as contas padrões do banco
    public static ArrayList<Conta> contas = new ArrayList<>(List.of(
            new Conta(new Titular("Davi Santos", "666666"),1000.0, "senha"),
            new Conta(new Titular("Lara Dantas", "444444"),1000.0, "senha"),
            new Conta(new Titular("Rafaela Borges", "555555"),1000.0, "senha")
    ));

    // Menu de pessoas
    public static List<String> MENU_PESSOAS = contas.stream().map((conta)-> conta.titular.getNome()).toList();


    // Geter e seter para acessar as contas.
    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }


    // Logar (Verificando cpf e senha)
    public boolean logar() {
        for (Conta conta: contas) {
            if (conta.titular.getCpf().equals(cpfDigitado)) {
                if (conta.getSenha().equals(senhaDigitada)) {
                    logado = true;
                    contaLogada = conta;
                    return true;
                }
            } else logado = false;
        }
        return logado;
    }


    // Deslogar da conta.
    public boolean deslogar() {
        if (logado == true) {
            logado = false;
            contaLogada = null;
        }
        return false;
    }


    // Descobrir se tem conta logada
    public void temContaLogada() {
        if (logado == true) {
            System.out.println("Tem conta logada.");
        } else {
            System.out.println("Não tem conta logada.");
        }
    }

    // Imprimir menu
    public void imprimirMenu(List<String> menu) {
        int enumeracao = 0;
        for (String opcao: menu) {
            enumeracao++ ;
            opcao = enumeracao + " - " + opcao;
            System.out.println(opcao);
        }
    }

    // Imprimir título
    public void imprimirTitulo(String titulo) {

        System.out.println("\n");
        for (int i = 0; i < titulo.length()+2; i++) {
            System.out.printf("=");
        }
        System.out.println("\n" + " " + titulo);
        for (int i = 0; i < titulo.length() + 2; i++) {
            System.out.printf("=");
        }
        System.out.println("\n");
    }

    
}
