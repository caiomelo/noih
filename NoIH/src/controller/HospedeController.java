/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.HospedeDAO;
import java.util.List;
import model.Hospede;
/**
 *
 * @author RodriguesMoises
 */
@Resource
public class HospedeController {
    private Result result;
    
    public HospedeController(Result result)
    {
        this.result = result;
    }
    
    public void novo()
    {
        
    }
    
    public void adiciona(Hospede hospede)
    {
        if(hospede.getId() == 0)
        {
            HospedeDAO.create(hospede);
        }
        else
        {
            HospedeDAO.update(hospede);
        }
        result.forwardTo(this).hospedes();
    }
    
    public List<Hospede> hospedes()
    {
        return HospedeDAO.getAll();
    }
    
    public Hospede editar(Hospede hospede)
    {
        hospede = HospedeDAO.read(hospede.getId());
        return hospede;
    }
    
    public void excluir(Hospede hospede)
    {
        HospedeDAO.delete(hospede.getId());
        result.forwardTo(this).hospedes();
    }
}
