/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package projeto2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafaelcosta
 */
public class Projeto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer option = -1;
        
        List<Usuario> lista = new ArrayList();
        List<Ingresso> filmes = new ArrayList();
        Scanner entrada = new Scanner(System.in) ;
        //Iterator<Cadastro> itr = lista.iterator();
        
        filmes.add(new Ingresso("Ted", "9h00", 30));
        filmes.add(new Ingresso("Rambo", "23h00", 30));
        
        
        
        int i;
        
        while ( option != 0 ) {

			// Exibe as opções
			System.out.println( "Escolha a opção" ) ;
			System.out.println( "1 - Cadastrar" ) ;
			System.out.println( "2 - Ver lista" ) ;
                        System.out.println( "3 - Compra" ) ;
			System.out.println( "0 - Sair" ) ;

			option = (Integer) entrada.nextInt() ;

			// Trata as opções
			try {
				switch ( option ) {
					case 1: cadastra(lista) ; break ;
					case 2: mostra(lista) ; break ;
                                        case 3: compra(filmes) ; break ;
				}
			}
			catch ( Exception e ) {
				System.out.println( e.getMessage() ) ;
			}

		}
        
        
        
        
        
        
        //System.out.println(cadastro.get(0).getNome()+"\n"+cadastro.get(0).getCpf()+"\n"+cadastro.get(0).getSenha());
        
    }
    
    private static void cadastra(List<Usuario> list){
         
        Usuario c = new Usuario();
        String nome, cpf, senha;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Nome: ");
        nome = entrada.nextLine() ;
        c.setNome(nome);
        
        System.out.println("CPF: ");
        cpf = entrada.nextLine() ;
        c.setCpf(cpf);
        
        System.out.println("Senha: ");
        senha = entrada.nextLine() ;
        c.setSenha(senha);
        
        list.add(c);
        
        }
    
    private static void mostra(List<Usuario> list){
        
        System.out.println("Lista atual");
        
        int i = 0;
        while(i<list.size()/*itr.hasNext()*/){
            System.out.print("\nNome: "+list.get(i).getNome());
            System.out.print("\nCPF: "+list.get(i).getCpf());
            System.out.print("\nSenha: "+list.get(i).getSenha());
            System.out.print("\n\n");
            i++;
        }
        
    }
    
    
    public static void compra(List<Ingresso> list) {
        System.out.println("Qual filme:\n");
        Scanner entrada = new Scanner(System.in) ;
        int op;
        
        int i = 0;
        while(i<list.size()/*itr.hasNext()*/){
            System.out.println(i+" - " + list.get(i).getNomeFilme());
            i++;
        }
        
        op = entrada.nextInt() ;
        
        
        
        
    }
}