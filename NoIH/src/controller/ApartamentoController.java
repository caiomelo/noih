/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ApartamentoDAO;
import java.util.List;
import model.Apartamento;

/**
 *
 * @author Caio
 */
@Resource
public class ApartamentoController {
    
    private Result result;
    private Apartamento apartamento;
    private List<Apartamento> apartamentos;
    
    public ApartamentoController(Result result)
    {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }
    
    public void novo()
    {
        
    }
    
    public void adiciona(Apartamento apartamento)
    {
        System.out.println("\nadicionando...\n");
        if(apartamento.getId() == 0)
        {
            ApartamentoDAO.create(apartamento);
        }
        else
        {
            ApartamentoDAO.update(apartamento);
        }
        getResult().forwardTo(this).apartamentos();
    }
    
    public List<Apartamento> apartamentos()
    {
        return ApartamentoDAO.getAll();
    }
    
    public Apartamento editar(Apartamento apartamento)
    {
        apartamento = ApartamentoDAO.read(apartamento.getId());
        return apartamento;
    }
    
    public void excluir(Apartamento apartamento)
    {
        ApartamentoDAO.delete(apartamento.getId());
        getResult().forwardTo(this).apartamentos();
    }
}
