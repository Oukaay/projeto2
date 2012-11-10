/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package projeto2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafaelcosta
 */
public class Principal {

    private static ClienteController clienteController = new ClienteController();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Integer option = -1;
        
   
        List<Ingresso> filmes = new ArrayList();
        Scanner entrada = new Scanner(System.in) ;
        //Iterator<Cadastro> itr = lista.iterator();
        
        filmes.add(new Ingresso("Ted", "9h00", 1));
        filmes.add(new Ingresso("Rambo", "23h00", 2));
        
        
        
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
					case 1: cadastra() ; break ;
                                        
				}
			}
			catch ( Exception e ) {
				System.out.println( e.getMessage() ) ;
			}

		}
        
        
    }
    
    private static void cadastra(){
         
        Cliente c = new Cliente();
        String nome, cpf;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Nome: ");
        nome = entrada.nextLine() ;
        c.setNome(nome);
        
        System.out.println("CPF: ");
        cpf = entrada.nextLine() ;
        c.setCpf(cpf);
        
        boolean cadastrou = clienteController.cadastraCliente(c);
                
        if (!cadastrou){
            System.out.println("Cliente ja cadastrado");
        
        }
    }
    
    public static void compra(List<Ingresso> list) throws IngressoException{
        
        System.out.println("Qual filme:\n");
        Scanner entrada = new Scanner(System.in) ;
        int op; int lugar=0;
        
        int i = 0;
        while(i<list.size()/*itr.hasNext()*/){
            System.out.println(i+" - " + list.get(i).getNomeFilme());
            i++;
        }
        
        op = entrada.nextInt() ;
        
        lugar = list.get(i).getLugar();
        list.get(i).setLugar(lugar-1);
        
        System.out.println("Ingresso comprado!");
        
    
       
         
    }
}