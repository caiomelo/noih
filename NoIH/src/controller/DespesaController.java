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
import java.util.List;
import model.Despesa;
import model.Registro;
import model.Servico;

/**
 *
 * @author Caio
 */
@Resource
public class DespesaController {

    private Result result;

    public DespesaController(Result result) {
        this.result = result;
    }

    public void lancamento(long registroId) {
        List<Servico> servicos = ServicoDAO.getAll();
        result.include("servicos", servicos);
        result.include("registro", RegistroDAO.read(registroId));
    }

    public void adiciona(long despesaId, long servicoId, long registroId, double valor) {
        Servico servico = ServicoDAO.read(servicoId);
        Registro registro = RegistroDAO.read(registroId);
        Despesa despesa = DespesaDAO.read(despesaId);

        despesa.setServico(servico);
        despesa.setRegistro(registro);
        despesa.setValor(valor);

        System.out.println("\nadicionando...\n");
        if (despesa.getId() == 0) {
            despesa.setDataHora(new GregorianCalendar());
            DespesaDAO.create(despesa);
        } else {
            DespesaDAO.update(despesa);
        }
        result.forwardTo(this).despesas();

    }

    public void lista(long registroId, String hospede, String apartamento) {
        List<Despesa> despesas = DespesaDAO.getAllFromRegistro(registroId);
        result.include("despesas", despesas);
        result.include("hospede", hospede);
        result.include("apartamento", apartamento);
    }

    public void despesas() {
        List<Registro> registros = RegistroDAO.getAll();
        result.include("registros", registros);
    }

    public void estorno(long despesaId) {
        DespesaDAO.delete(despesaId);
        result.forwardTo(this).despesas();
    }

    public void editar(Despesa despesa) {
        despesa = DespesaDAO.read(despesa.getId());
        result.include("despesas", despesa);
    }
}
