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

    private int getLugar() {
        return nroLugares;
    }

    private void setLugar(int lugar) {
        this.nroLugares = lugar;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    private void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    private String getHorario() {
        return horario;
    }

    private void setHorario(String horario) {
        this.horario = horario;
    }
    
    public boolean compraIngresso(){
        
        if (nroLugares > 0){
            nroLugares--;
            return true;
        }       
        return false;
        
    }
    
    
}
