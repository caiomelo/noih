/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RodriguesMoises
 */
public class Apartamento {
    //Primary key
    private long id;
    private int andar;
    private int numero;
    private String tipo;

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Apartamento{" + "id=" + id + ", andar=" + andar + ", numero=" + numero + ", tipo=" + tipo + '}';
    }
}
