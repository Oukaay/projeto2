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
public class Cadastra{
        private static ClienteController clienteController = new ClienteController();
        
        public static void cadastra() {
            

        Cliente c = new Cliente();
        String nome, cpf;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Iniciando Cadastro\n");
        System.out.println("Nome: ");
        nome = entrada.nextLine();
        c.setNome(nome);

        System.out.println("CPF: ");
        cpf = entrada.nextLine();
        c.setCpf(cpf);

        boolean cadastrou = clienteController.cadastraCliente(c);

        if (!cadastrou) {
            System.out.println("Cliente ja cadastrado");

        }
    }
    
}
