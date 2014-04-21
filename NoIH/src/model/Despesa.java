/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.GregorianCalendar;

/**
 *
 * @author RodriguesMoises
 */
public class Despesa {
    //Primary key
    private long id;
    private GregorianCalendar dataHora;
    private Registro registro;
    private Servico servico;
    private double valor;

    public GregorianCalendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(GregorianCalendar dataHora) {
        this.dataHora = dataHora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Despesa{" + "id=" + id + ", dataHora=" + dataHora + ", registro=" + registro + ", valor=" + valor + '}';
    }
}
