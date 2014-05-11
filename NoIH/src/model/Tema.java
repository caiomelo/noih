/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RodriguesMoises
 */
public class Tema {
    //Primary key
    private long temaId;
    private String tema;

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public long getTemaId() {
        return temaId;
    }

    public void setTemaId(long temaId) {
        this.temaId = temaId;
    }

    @Override
    public String toString() {
        return "Tema{" + "temaId=" + temaId + ", tema=" + tema + '}';
    }
}
