/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;


/**
 *
 * @author ViniSilva
 */
public class Cliente {
    
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    

    public Cliente() {
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    
}
