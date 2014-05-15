/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ApartamentoDAO;
import dao.HospedeDAO;
import dao.RegistroDAO;
import dao.ReservaDAO;
import java.util.GregorianCalendar;
import model.*;

/**
 *
 * @author RodriguesMoises
 */
@Resource
public class CheckController {
    private Result result;

    public CheckController(Result result) {
        this.result = result;
    }
    
    public void hospedereserva()
    {
        result.include("reservas", ReservaDAO.getAll());
        result.include("hospedes", HospedeDAO.getAll());
    }
    
    public void apartamento(Hospede hospede, Reserva reserva)
    {
        result.include("reserva", reserva.getId());
        result.include("hospede", hospede.getId());
        result.include("apartamentos", ApartamentoDAO.getAll());
        System.out.println("reserva.getId(): " + reserva.getId());
        System.out.println("hospede.getId(): " + hospede.getId());
    }
    
    public void checkin(Hospede hospede, Reserva reserva, Apartamento apartamento)
    {
        Registro registro = new Registro();
        apartamento = ApartamentoDAO.read(apartamento.getId());
        reserva = ReservaDAO.read(reserva.getId());
        registro.setApartamento(apartamento);
        registro.setHospede(hospede);
        registro.setReserva(reserva);
        registro.setCheckin(new GregorianCalendar());
        registro.setCheckout(reserva.getDataFim());
        registro.setFuncionario(new Funcionario());
        RegistroDAO.create(registro);
        result.include("apartamento", apartamento);
        result.include("hospede", hospede);
    }
    
}
