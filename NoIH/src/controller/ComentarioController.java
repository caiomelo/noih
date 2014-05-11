/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ComentarioDAO;
import dao.TemaDAO;
import java.util.List;
import model.Comentario;
import model.Tema;

/**
 *
 * @author RodriguesMoises
 */

@Resource
public class ComentarioController {
    private Result result;
    private long temaId;

    public ComentarioController(Result result)
    {
        this.result = result;
    }
    
    public void formulario()
    {
        
    }
    
    public void adiciona(Comentario comentario)
    {
        System.out.println("\nadicionando...\n");
        Tema tema = TemaDAO.read(comentario.getTema());
        if(tema == null)
        {
            tema = new Tema();
            tema.setTema(comentario.getTema());
            TemaDAO.create(tema);
        }
        
        comentario.setTemaId(tema.getTemaId());
        temaId = comentario.getTemaId();
        ComentarioDAO.create(comentario);
        //result.forwardTo("/WEB-INF/jsp/comentario/adicionado.jsp");
        result.forwardTo(this).lista();
    }
    
    public List<Comentario> lista()
    {
        return ComentarioDAO.getAll(temaId);
    }
}
