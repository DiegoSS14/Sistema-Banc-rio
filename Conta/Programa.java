package Exercicios.SistemaBancarioRefeito.Conta;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Programa {

    Conta conta;

    public static void executar() {

        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        int opcao3;
        int opcao2;
        int opcao1 = -1;

        do {
            // Login
            login.imprimirTitulo("Fazer login");
            login.imprimirMenu(Login.MENU_HOME);
            System.out.print("\nDigite a opção escolhida: ");
            opcao1 = scanner.nextInt();

            // Verificação de CPF e senha
            switch (opcao1) {
                case 1:
                    System.out.print("Digite o CPF: ");
                    login.cpfDigitado = scanner.next();

                    System.out.print("Digite a senha: ");
                    login.senhaDigitada = scanner.next();

                        login.logar();

                        // Tratamento de erro
                        if (login.logar() != true) {
                            System.out.println("\nCPF ou senha inválidos. ");
                            return;
                        }
                        break;

                case 2:
                    System.out.println("Sessão encerrada");
                    return;

                default:
                    System.out.println("Opção inválida");
                    return;
            }


            do {
                //Home
                login.imprimirTitulo("Home");
                System.out.print(String.format("A sua conta tem R$ %.2f \nO que deseja fazer?\n\n",
                        Login.contaLogada.getSaldo()));
                login.imprimirMenu(Login.MENU_LOGADO);
                System.out.print("\nDigite a opção escolhida: ");

                double usarValor;
                opcao2 = scanner.nextInt();

                switch (opcao2) {
                    case 1:
                        login.imprimirTitulo("Saque");
                        System.out.print(String.format("A sua conta tem R$ %.2f \nQual valor você deseja sacar? ",
                                Login.contaLogada.getSaldo()));
                        usarValor = Double.parseDouble(scanner.next().replace(",", "."));
                        Login.contaLogada.sacar(usarValor);
                        break;

                    case 2:
                        login.imprimirTitulo("Transferência");
                        System.out.print(String.format("A sua conta tem R$ %.2f \nQual valor você deseja transferir? ",
                                Login.contaLogada.getSaldo()));
                        usarValor = Double.parseDouble(scanner.next().replace(",", "."));

                        System.out.println("Para quem você deseja transferir? ");

                        List<String> listaPessoasSemOTitular = Login.MENU_PESSOAS
                                .stream()
                                .filter((nomeMenu) -> !nomeMenu.equals(Login.contaLogada.titular.getNome()))
                                .collect(Collectors.toList());

                        login.imprimirMenu(listaPessoasSemOTitular);

                        opcao3 = scanner.nextInt();
                        if (opcao3 < login.getContas().size()) {

                            String pessoaEscolhida = listaPessoasSemOTitular.get(opcao3 - 1);
                            int indiceListaOriginal = Login.MENU_PESSOAS.indexOf(pessoaEscolhida);

                            Login.contaLogada.transferir(usarValor, login.getContas().get(indiceListaOriginal));
                            break;
                        } else {
                            System.out.println("\nO valor que você digitou é um valor inválido.");
                            break;
                        }

                    case 3:
                        login.imprimirTitulo("Depósito");
                        System.out.print(String.format("A sua conta tem R$ %.2f \nQual valor você deseja depositar? ",
                                Login.contaLogada.getSaldo()));
                        usarValor = Double.parseDouble(scanner.next().replace(",", "."));
                        Login.contaLogada.depositar(usarValor);
                        System.out.println(String.format("\nVocê depositou R$ %.2f em sua conta. ", usarValor));
                        break;

                    case 4:
                        System.out.println("Sua conta foi deslogada.");
                        login.deslogar();
                        opcao2 = 4;
                }

            } while (opcao2 != 4);

        } while (opcao1 != 2);

        // todo - Tratar erros caso o usuário não digite valores válidos para os casos. (resolvido)
        // todo - o nome do usuário logado da lista de transferências. (A resolver)

//        login.temContaLogada();
        scanner.close();
    }
}
