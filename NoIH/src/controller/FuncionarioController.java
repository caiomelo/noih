/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.FuncionarioDAO;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author Caio
 */
@Resource
public class FuncionarioController {
    private Result result;
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    
    public FuncionarioController(Result result)
    {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    
    public void novo()
    {
        
    }
    
    public void adiciona(Funcionario funcionario)
    {
        System.out.println("\nadicionando...\n");
        if(funcionario.getId() == 0)
        {
            FuncionarioDAO.create(funcionario);
        }
        else
        {
            FuncionarioDAO.update(funcionario);
        }
        getResult().forwardTo(this).funcionarios();
    }
    
    public List<Funcionario> funcionarios()
    {
        return FuncionarioDAO.getAll();
    }
    
    public Funcionario editar(Funcionario funcionario)
    {
        funcionario = FuncionarioDAO.read(funcionario.getId());
        return funcionario;
    }
    
    public void excluir(Funcionario funcionario)
    {
        FuncionarioDAO.delete(funcionario.getId());
        getResult().forwardTo(this).funcionarios();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
