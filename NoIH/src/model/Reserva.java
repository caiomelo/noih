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
public class Reserva {
    //Primary key
    private long id;
    private Apartamento apartamento;
    private Hospede hospede;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;
    private Funcionario funcionario;

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public GregorianCalendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(GregorianCalendar dataFim) {
        this.dataFim = dataFim;
    }

    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", apartamento=" + apartamento + ", hospede=" + hospede + ",\n dataInicio=" + dataInicio.getTime() + ",\n dataFim=" + dataFim.getTime() + ", funcionario=" + funcionario + '}';
    }
}
