/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ServicoDAO;
import model.Servico;
import java.util.List;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author RodriguesMoises
 */
@Resource
public class ServicoController {
    private Result result;
    private Servico servico;
    private List<Servico> servicos;
    
    public ServicoController(Result result)
    {
        this.result = result;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
    public void novo()
    {
        
    }
    
    public void adiciona(Servico servico)
    {
        System.out.println("\nadicionando...\n");
        ServicoDAO.create(servico);
        //result.forwardTo("/WEB-INF/jsp/comentario/adicionado.jsp");
        result.forwardTo(this).servicos();
    }
    
    public List<Servico> servicos()
    {
        return ServicoDAO.getAll();
    }
}
