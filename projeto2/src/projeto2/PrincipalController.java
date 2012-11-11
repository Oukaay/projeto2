/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ViniSilva
 */
public class PrincipalController {

    private static ClienteController clienteController = new ClienteController();
    private static Hashtable sessoes = new Hashtable();
    
    public PrincipalController(){
        sessoes.put(1, new Sessao("Ted", "9h00", 2));
        sessoes.put(2, new Sessao("Ted", "22h00", 5));
        sessoes.put(3, new Sessao("Rambo", "10h00", 2));
        sessoes.put(4, new Sessao("Rambo", "23h00", 5));
        sessoes.put(5, new Sessao("Premonicao", "10h00", 2));
        sessoes.put(6, new Sessao("Premonicao", "21h00", 5));
    }

    public void cadastra() {

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

    public void listaSessoes() {

        int i = 1;
        System.out.println("Sessoes 01/11/2012 - 15/11/2012:\n");
        while (i <= sessoes.size() /*itr.hasNext()*/) {
            Sessao sessao = (Sessao) sessoes.get(i);

            System.out.println(i + " - Filme:" + sessao.getNomeFilme());
            System.out.println(" - Horario:" + sessao.getHorario());
            System.out.println(" - Ingressos Disponiveis:" + sessao.getNroLugares());
            i++;

        }
        Scanner entrada = new Scanner(System.in);
        entrada.nextLine();

    }
    
    public  void compra() throws IngressoException {

        int op;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Login:\n");
        System.out.println("Digite seu CPF: ");
        String cpf = entrada.nextLine();
        
        
        if (!clienteController.clienteExiste(cpf)) {
            System.out.println("\nCliente nao cadastrado");
//            return;

            System.out.println("\nRealizar Cadastro?" + " \n 1 - sim 2 - nao");
            op = entrada.nextInt();

            if (op == 1) {
                cadastra();
                compra();
            } else {
                return;
            }
        }
        Cliente logado = clienteController.buscaCliente(cpf);
        System.out.println("Cliente: "+ logado.getNome() + "Logado");
        System.out.println("Qual filme:\n");
        entrada = new Scanner(System.in);

        int i = 1;

        while (i <= sessoes.size() /*itr.hasNext()*/) {
            Sessao sessao = (Sessao) sessoes.get(i);

            System.out.println(i + " - Filme:" + sessao.getNomeFilme());
            System.out.println(" - Horario:" + sessao.getHorario());
            System.out.println(" - Ingressos Disponiveis:" + sessao.getNroLugares());
            i++;
        }
        System.out.println("Digite sua opcao:\n");
        op = entrada.nextInt();
        Sessao sessaoSelecionada = getSessao(op);
        
        if (sessaoSelecionada == null) {
            System.out.println("Sessao invalida.");
        } else {
            boolean sucesso = sessaoSelecionada.compraIngresso();

            if (sucesso) {
                System.out.println("Ingresso comprado!!");
            } else {
                System.out.println("Ingressos Esgotados");
            }
        }

    }
    
    public Sessao getSessao(int id){
        return (Sessao)sessoes.get(id);
    }
    
    public List<Sessao> buscaSessoes(String nomeFilme) {
        ArrayList<Sessao> sessoesEncontradas = new ArrayList<Sessao>();
        int i = 1;
        while (i <= sessoes.size() /*itr.hasNext()*/) {
            Sessao sessao = (Sessao) sessoes.get(i);

            if (sessao.getNomeFilme().contains(nomeFilme)){
                sessoesEncontradas.add(sessao);
            } 
            i++;

        }
        return sessoesEncontradas;
    }
    
    public void buscaSessoes(){
        int op;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do filme que deseja buscar:\n");
        String nomeFilme = entrada.nextLine();
        
        ArrayList<Sessao> sessoes = (ArrayList<Sessao>) buscaSessoes(nomeFilme);
        
        if( sessoes.size() == 0){
            System.out.println("Sessao inexistente");
        }
        
        else {
            for (Sessao ses : sessoes) {

                System.out.println(" - Filme:" + ses.getNomeFilme());
                System.out.println(" - Horario:" + ses.getHorario());
                System.out.println(" - Ingressos Disponiveis:" + ses.getNroLugares());

            }
        }

        
        
    }
    
}
