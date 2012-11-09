/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

/**
 *
 * @author ViniSilva
 */
public class Cadastro {
    
    private String nome;
    private String cpf;
    private String senha;


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean equals( Cadastro cadastro ) {
		if ( cadastro == this ) return true ;

		return ( cadastro.getNome().equals( this.nome ) &&
                        	cadastro.getSenha().equals( this.senha ) &&
                                cadastro.getCpf().equals (this.cpf)  );
	}
    
}
