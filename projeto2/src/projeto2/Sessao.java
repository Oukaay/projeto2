/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

/**
 *
 * @author rafaelcosta
 */
public class Sessao {
    
    private String nomeFilme;
    private String horario;
    private int nroLugares;
    
    
    Sessao(String nomeFilme, String horario, int lugar){
        this.nomeFilme = nomeFilme;
        this.horario = horario;
        this.nroLugares = lugar;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNroLugares() {
        return nroLugares;
    }

    public void setNroLugares(int nroLugares) {
        this.nroLugares = nroLugares;
    }      
    
    public boolean compraIngresso(){
        
        if (nroLugares > 0){
            nroLugares--;
            return true;
        }       
        return false;
        
    }
    
    
}
