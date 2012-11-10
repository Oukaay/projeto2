/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package projeto2;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**0
 * 
 *
 * @author rafaelcosta
 */
public class Principal {

    private static ClienteController clienteController = new ClienteController();
    
    private static Hashtable sessoes = new Hashtable();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer option = -1;
  
        
        Scanner entrada = new Scanner(System.in) ;
    
        sessoes.put(1,new Sessao("Ted", "9h00", 2));
        sessoes.put(2,new Sessao("Rambo", "23h00", 3));
        
        int i;
        
        while ( option != 0 ) {

			// Exibe as opções
		System.out.println( "Escolha a opção" ) ;
		System.out.println( "1 - Cadastrar" ) ;
                System.out.println( "2 - Ver lista" ) ;
                System.out.println( "3 - Compr" ) ;
		System.out.println( "0 - Sair" ) ;
                
                option = (Integer) entrada.nextInt() ;

			// Trata as opções
		try {
			switch ( option ) {
                            case 1: cadastra() ; break ;
                            case 3: compra(); break;    
                                        
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
    
    public static void compra() throws IngressoException{
        
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu CPF: ");
        String cpf = entrada.nextLine() ;
        
        if (!clienteController.clienteExiste(cpf)){
            System.out.println("Cliente nao cadastrado");
            return;
        }
        
        System.out.println("Qual filme:\n");
        entrada = new Scanner(System.in) ;
        
        int op; 
  
        int i = 1;
        
        while(i<=sessoes.size() /*itr.hasNext()*/){
            Sessao sessao = (Sessao)sessoes.get(i);
                    
            System.out.println(i+" - " + sessao.getNomeFilme());
            i++;
        }
        
        op = entrada.nextInt() ;
        
        Sessao sessaoSelecionada = (Sessao)sessoes.get(op);
        
        boolean sucesso = sessaoSelecionada.compraIngresso();
        
        if (sucesso){
            System.out.println("Ingresso comprado!!");
        }else{
            System.out.println("Vai assistir filme em casa");
        }
        
     

    }
}