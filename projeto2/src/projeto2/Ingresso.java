/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

/**
 *
 * @author rafaelcosta
 */
public class Ingresso {
    
    private String nomeFilme;
    private String horario;
    private int lugar;
    
    Ingresso(String nomeFilme, String horario, int lugar){
        this.nomeFilme = nomeFilme;
        this.horario = horario;
        this.lugar = lugar;
    }

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
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
    
    
}
