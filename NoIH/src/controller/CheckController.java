/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import model.*;

/**
 *
 * @author RodriguesMoises
 */
@Resource
public class CheckController {
    private Result result;
    private Apartamento apartamento;

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
        result.include("reserva", reserva);
        result.include("hospede", hospede);
        
        Date date = null;
        if(reserva.getId() != 0)
        {
            date = reserva.getDataFim().getTime();            
        }
        else
        {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            date = calendar.getTime();
        }
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        result.include("dataFim", df.format(date));
        result.include("apartamentos", ApartamentoDAO.getAll());
        System.out.println("reserva.getId(): " + reserva.getId());
        System.out.println("hospede.getId(): " + hospede.getId());
    }
    
    public void checkin(Hospede hospede, Reserva reserva, Apartamento apartamento)
    {
        Registro registro = new Registro();
        apartamento = ApartamentoDAO.read(apartamento.getId());
        if(reserva.getId() != 0)
        {
            reserva = ReservaDAO.read(reserva.getId());
        }
        registro.setReserva(reserva);
        registro.setCheckout(reserva.getDataFim());
        registro.setApartamento(apartamento);
        registro.setHospede(hospede);
        registro.setCheckin(new GregorianCalendar());
        registro.setFuncionario(new Funcionario());
        registro.setStatus(Registro.ABERTO);
        ArrayList<Registro> registros = RegistroDAO.getAllFromApartamento(apartamento);
        boolean hasIntersection = false;
        for(Registro r : registros)
        {
            if(hasDateIntersection(registro, r))
            {
                hasIntersection = true;
            }
        }
        
        if(!hasIntersection)
        {
            RegistroDAO.create(registro);
            result.include("apartamento", apartamento);
            result.include("hospede", hospede);
        }
        else
        {
            this.apartamento = apartamento;
            result.forwardTo(this).apartamentoOcupado();
        }
    }
    
    public Apartamento apartamentoOcupado()
    {
        return apartamento;
    }

    public void checkout()
    {
        result.include("registros", RegistroDAO.getAllOpen());
    }
    
    public void despesas(Registro registro)
    {
        registro = RegistroDAO.read(registro.getId());
        result.include("despesas", DespesaDAO.getAllFromRegistro(registro.getId()));
        result.include("registro", registro);
    }
    
    public void registroFechado(Registro registro)
    {
        registro = RegistroDAO.read(registro.getId());
        registro.setStatus(Registro.FECHADO);
        RegistroDAO.update(registro);
        result.include("registro", registro);
    }
    
    private boolean hasDateIntersection(Registro registro1, Registro registro2)
    {
        boolean hasIntersection = false;
        if(between(registro1.getCheckin(), registro2.getCheckin(), registro2.getCheckout()))
        {
            hasIntersection = true;
        }
        if(between(registro1.getCheckout(), registro2.getCheckin(), registro2.getCheckout()))
        {
            hasIntersection = true;
        }
        
        if(between(registro2.getCheckin(), registro1.getCheckin(), registro1.getCheckout()))
        {
            hasIntersection = true;
        }
        if(between(registro2.getCheckout(), registro1.getCheckin(), registro1.getCheckout()))
        {
            hasIntersection = true;
        }
        
        return hasIntersection;
    }
    
    private boolean between(GregorianCalendar calendar1, GregorianCalendar calendar2, GregorianCalendar calendar3)
    {
        boolean between = false;
        if(calendar1.after(calendar2) || calendar1.before(calendar3))
        {
            between = true;
        }
        return between;
    }
}
