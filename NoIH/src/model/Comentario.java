/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RodriguesMoises
 */
public class Comentario {
    //Primary key
    private long comentarioId;
    private String comentario;
    private String tema;
    private long temaId;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public long getTemaId() {
        return temaId;
    }

    public void setTemaId(long temaId) {
        this.temaId = temaId;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "ComentarioTema{" + "comentarioId=" + comentarioId + ", comentario=" + comentario + ", temaId=" + temaId + '}';
    }
}
