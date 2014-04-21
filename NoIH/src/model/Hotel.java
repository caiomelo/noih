/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RodriguesMoises
 */
public class Hotel {
    //Primary key
    private long id;
    private long nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNome() {
        return nome;
    }

    public void setNome(long nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", nome=" + nome + '}';
    }
}
