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
public class Registro {
    //Primary key
    private long id;
    private GregorianCalendar checkin;
    private GregorianCalendar checkout;
    private Reserva reserva;
    private Hospede hospede;
    private Apartamento apartamento;
    private Funcionario funcionario;

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public GregorianCalendar getCheckin() {
        return checkin;
    }

    public void setCheckin(GregorianCalendar checkin) {
        this.checkin = checkin;
    }

    public GregorianCalendar getCheckout() {
        return checkout;
    }

    public void setCheckout(GregorianCalendar checkout) {
        this.checkout = checkout;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", checkin=" + checkin + ", checkout=" + checkout + ", reserva=" + reserva + ", hospede=" + hospede + ", apartamento=" + apartamento + ", funcionario=" + funcionario + '}';
    }
}
