/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.TemaDAO;
import model.Tema;

/**
 *
 * @author RodriguesMoises
 */

@Resource
public class TemaController {
    private Result result;
    private Tema tema;
    
    public TemaController(Result result)
    {
        this.result = result;
    }
    
    public void formulario()
    {
        
    }
    
    public Tema temaCadastrado()
    {
        return tema;
    }
    
    public void adiciona(Tema tema)
    {
        TemaDAO.create(tema);
        this.tema = tema;
        result.forwardTo(this).temaCadastrado();
    }
    
    
}
