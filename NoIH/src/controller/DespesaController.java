/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.DespesaDAO;
import dao.RegistroDAO;
import dao.ServicoDAO;
import java.util.GregorianCalendar;
import model.*;
/**
 *
 * @author RodriguesMoises
 */
@Resource
public class DespesaController {
    private Result result;
    
    public DespesaController(Result result)
    {
        this.result = result;
    }
    
    public void despesas()
    {
        
    }
    
    public void lancamento()
    {
        result.include("registros", RegistroDAO.getAllOpen());
        result.include("servicos", ServicoDAO.getAll());
    }
    
    public void lancado(Registro registro, Servico servico)
    {
        registro = RegistroDAO.read(registro.getId());
        servico = ServicoDAO.read(servico.getId());
        
        Despesa despesa = new Despesa();
        despesa.setDataHora(new GregorianCalendar());
        despesa.setRegistro(registro);
        despesa.setServico(servico);
        despesa.setValor(servico.getValor());
        registro.setTotalConta(registro.getTotalConta() + servico.getValor());
        
        DespesaDAO.create(despesa);
        RegistroDAO.update(registro);
        
        result.include("registro", registro);
        result.include("servico", servico);
    }
    
    public void estorno()
    {
        result.include("registros", RegistroDAO.getAllOpen());
    }
    
    public void servico(Registro registro)
    {
        registro = RegistroDAO.read(registro.getId());
        result.include("registro", registro);
        result.include("despesas", DespesaDAO.getAllFromRegistro(registro.getId()));
    }
    
    public void estornado(Registro registro, Despesa despesa)
    {
        registro = RegistroDAO.read(registro.getId());
        despesa = DespesaDAO.read(despesa.getId());
        
        registro.setTotalConta(registro.getTotalConta() - despesa.getServico().getValor());
        DespesaDAO.delete(despesa.getId());
        RegistroDAO.update(registro);
        
        result.include("registro", registro);
        result.include("despesa", despesa);
    }
}
