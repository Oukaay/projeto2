/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.Scanner;

/**
 *
 * @author ViniSilva
 */
public class Principal {

    private static PrincipalController controller = new PrincipalController();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer option = -1;
        Scanner entrada = new Scanner(System.in);
        int i;

        while (option != 0) {

            // Exibe as opções
            System.out.println("Bem Vindo ao Ingresso Online\n");
            System.out.println("Escolha a opção");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Lista todas as sessoes");
            System.out.println("3 - Compra");
            System.out.println("4 - Consulta Sessoes");
            System.out.println("0 - Sair");
            System.out.println("Opcao: ");

            option = (Integer) entrada.nextInt();

            // Trata as opções
            try {
                switch (option) {
                    case 1:
                        controller.cadastra();
                        break;
                    case 2:
                        controller.listaSessoes();
                        break;
                    case 3:
                        controller.compra();
                        break;
                    case 4:
                        controller.buscaSessoes();
                        break;
                    default:
                        System.out.println("Opcao invalida.");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}