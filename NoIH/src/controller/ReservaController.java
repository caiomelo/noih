/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ApartamentoDAO;
import dao.ReservaDAO;
import java.util.List;
import model.Apartamento;
import model.Reserva;

/**
 *
 * @author Caio
 */
@Resource
public class ReservaController {
    private Result result;
    private Reserva reserva;
    private List<Reserva> reservas;
    
    public ReservaController(Result result)
    {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public void novo()
    {
        
    }
    
    public void adiciona(Reserva reserva)
    {
        System.out.println("\nadicionando...\n");
        if(reserva.getId() == 0)
        {
            ReservaDAO.create(reserva);
        }
        else
        {
            ReservaDAO.update(reserva);
        }
        getResult().forwardTo(this).reservas();
    }
    
    public List<Reserva> reservas()
    {
        return ReservaDAO.getAll();
    }
    
    public void editar(Reserva reserva)
    {
        reserva = ReservaDAO.read(reserva.getId());
        result.include(reserva);
    }
    
    public void excluir(Reserva reserva)
    {
        ReservaDAO.delete(reserva.getId());
        getResult().forwardTo(this).reservas();
    }
    
    public void apartamentos()
    {
        result.include("apartamentos", ApartamentoDAO.getAll());
    }
}