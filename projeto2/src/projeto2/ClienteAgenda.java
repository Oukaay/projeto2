/*

import java.rmi.Naming ;
import java.rmi.* ;
import java.util.Scanner ;
import java.util.Iterator ;
import java.util.List ;
import java.util.ArrayList ;

class ListaVaziaException extends Exception {
	ListaVaziaException( String msg ) {
		super( msg ) ;
	}
}

public class ClienteAgenda {

	private static AgendaController agenda ;
	private static int callbackId ;

	public static void main( String args[] ) {
		Integer option = -1 ;

		Scanner entrada = new Scanner(System.in) ;

		// Inicialiando o RMI
		ClienteAgenda.inicia_rmi() ;
		ClienteAgenda.cadastraCallback() ;

		//System.setSecurityManager(new RMISecurityManager()) ;

		while ( option != 0 ) {

			// Exibe as opções
			System.out.println( "Escolha a opção" ) ;
			System.out.println( "1 - Incluir novo aniversário" ) ;
			System.out.println( "2 - Ver lista de aniversários" ) ;
			System.out.println( "3 - Remover contato" ) ;
			System.out.println( "4 - Ver detalhes do contato" ) ;
			System.out.println( "5 - Editar contato" ) ;
			System.out.println( "0 - Sair" ) ;

			option = (Integer) entrada.nextInt() ;

			// Trata as opções
			try {
				switch ( option ) {
					case 1: ClienteAgenda.incluir() ; break ;
					case 2: ClienteAgenda.verLista() ; break ;
					case 3: ClienteAgenda.remover() ; break ;
					case 4: ClienteAgenda.verDetalhes() ; break ;
					case 5: ClienteAgenda.editar() ; break ;
				}
			}
			catch ( Exception e ) {
				System.out.println( e.getMessage() ) ;
			}

		}

		// Descadastrando objeto de callback
		ClienteAgenda.desCadastraCallback() ;

		System.out.println( "Bye..." ) ;
		System.exit( 1 ) ;
	}

	// Cadastra objeto para callback
	private static void cadastraCallback() {
		try {
			CallbackController callback = new CallbackControllerImpl() ;
			ClienteAgenda.callbackId = ClienteAgenda.agenda.cadastraCallback( callback ) ;
		}
		catch ( Exception e ) {
			System.out.println( "Erro: " + e.getMessage() ) ;
		}
	}

	// Remove o callback
	private static void desCadastraCallback() {
		try {
			if ( ClienteAgenda.agenda.desCadastraCallback( ClienteAgenda.callbackId ) ) {
				System.out.println( "Callback Descadastrado com sucesso..." ) ;
			}
		}
		catch ( Exception e ) {
			System.out.println( "Erro: " + e.getMessage() ) ;
		}
	}

	// Incializa o tratamento do RMI
	private static void inicia_rmi() {

		try {
			ClienteAgenda.agenda = (AgendaController) Naming.lookup( "rmi://localhost:1099/AgendaController" ) ;
		}
		catch ( Exception e ) {
			System.out.println( "Problemas: " + e ) ;
		}

	}

	// Faz a inclusão de um aniversário
	private static void incluir() {
		Contato contato = new Contato() ;
		String nome , email , data ;
		qzaåœåΩåq ;

		System.out.println( "Entre com o nome do contato: " ) ;
		nome = entrada.nextLine() ;
		contato.setNome( nome ) ;

		System.out.println( "Entre com o e-mail: " ) ;
		email = entrada.nextLine() ;
		contato.setEmail( email ) ;

		System.out.println( "Entre com a data de nascimento (Formato 99/99/9999): " ) ;
		data = entrada.nextLine() ;
		contato.setDataNascimento( data ) ;

		try {
			ClienteAgenda.agenda.inserir( contato ) ;
			System.out.println( "Contato inserido com sucesso..." ) ;
		}
		catch ( Exception e ) {
			System.out.println( "Problemas..." + e ) ;
		}
	}

	// Visualiza a lista de aniversariantes
	private static void verLista() throws ListaVaziaException {
		List<Contato> contatos = new ArrayList<Contato>() ;

		try {
			contatos = ClienteAgenda.agenda.obterTodos() ;
		}
		catch ( RemoteException e ) {
			System.out.println( "Problemas..." + e ) ;
		}
			
		Contato contato ;
		Integer count = 0 ;

		if ( contatos.size() == 0 ) {
			throw new ListaVaziaException( "\n-- Lista vazia --\n" ) ;
		}

		Iterator<Contato> contatos_it = contatos.iterator() ;

		System.out.println( "\n-- Lista de Aniversarios --" ) ;
		while ( contatos_it.hasNext() ) {
			contato = contatos_it.next() ;
			System.out.println( (count++) + " - " + contato.getNome() + " - Nascimento: " + contato.getDataNascimento() ) ;
		}

		System.out.println( "" ) ;

	}

	// Visualizar detalhes do contato
	private static void verDetalhes() {
		try {
			int option ;
			Contato contato ;
			Scanner entrada = new Scanner( System.in ) ;

			ClienteAgenda.verLista() ;

			System.out.println( "\nEntre com o id do contato que deseja visualizar (-1 para cancelar): " ) ;
			option = entrada.nextInt() ;

			if ( option > -1 ) {
				contato = (Contato) ClienteAgenda.agenda.obter( option ) ;
				System.out.println( "---- Detalhes do contato ----" ) ;
				System.out.println( "Nome: " + contato.getNome() ) ;
				System.out.println( "E-mail: " + contato.getEmail() ) ;
				System.out.println( "Data de nascimento: " + contato.getDataNascimento() ) ;
				System.out.println( "\n" ) ;
			}
		}
		catch ( ListaVaziaException e ) {
			System.out.println( e.getMessage() ) ;
		}
		catch ( Exception e ) {
			System.out.println( "Erro: " + e ) ;
		}
	}

	// Visualiza a lista de aniversariantes
	private static void remover() {
		try {
			int option ;
			Scanner entrada = new Scanner(System.in) ;

			ClienteAgenda.verLista() ;

			System.out.println( "Escolha o contato que deseja remover (-1 para cancelar): " ) ;
			option = entrada.nextInt() ;
			if ( option > -1 ) {
				if ( ClienteAgenda.agenda.remover( option ) ) {
					System.out.println( "Contato removido com sucesso.. " ) ;
				}
			}
		}
		catch ( ListaVaziaException e ) {
			System.out.println( e.getMessage() ) ;
		}
		catch ( Exception e ) {
			System.out.println( "Problemas 2..." + e ) ;
		}
	}

	//Editar Contato
	private static void editar() {

		try {

			int position ;
			Scanner entrada = new Scanner( System.in ) ;
			Contato contato ;
			String nome , email , data ;

			ClienteAgenda.verLista() ;

			System.out.println( "Entre com o id do contato que deseja editar (-1 para cancelar): " ) ;
			position = entrada.nextInt() ;


			if ( position > -1 ) {
				contato = ClienteAgenda.agenda.obter( position ) ;

				entrada.nextLine() ;

				System.out.println( "O nome do contato eh '" + contato.getNome() + "', entre com o novo: " ) ;
				nome = entrada.nextLine() ;
				if ( ! nome.equals( "" ) ) {
					contato.setNome( nome ) ;
				}

				System.out.println( "O e-mail do contato eh '" + contato.getEmail() + "', entre com o novo: " ) ;
				email = entrada.nextLine() ;
				if ( ! email.equals( "" ) ) {
					contato.setEmail( email ) ;
				}

				System.out.println( "A data de nascimento do contato eh '" + contato.getDataNascimento() + "', entre com a nova (99/99/9999): " ) ;
				data = entrada.nextLine() ;
				if ( ! data.equals( "" ) ) {
					contato.setDataNascimento( data ) ;
				}

				ClienteAgenda.agenda.atualizar( position , contato ) ;
				System.out.println( "Contato alterado com sucesso\n" ) ;
			}
		}
		catch ( Exception e ) {
			System.out.println( e.getMessage() ) ;
		}

	}

}
* 
* /