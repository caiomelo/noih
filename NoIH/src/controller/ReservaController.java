/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ApartamentoDAO;
import dao.FuncionarioDAO;
import dao.HospedeDAO;
import dao.ReservaDAO;
import java.util.GregorianCalendar;
import java.util.List;
import model.Apartamento;
import model.Funcionario;
import model.Reserva;
import util.DateUtil;

/**
 *
 * @author Caio
 */
@Resource
public class ReservaController {

    private Result result;
    private static final String INTERNET = "Internet";

    public ReservaController(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void novoLocal() {
    }

    public void adiciona(Reserva reserva, String dataInicio, String dataFim) {
        reserva.setFuncionario(FuncionarioDAO.read(reserva.getFuncionario().getId()));
        reserva.setApartamento(ApartamentoDAO.read(reserva.getApartamento().getId()));
        reserva.setHospede(HospedeDAO.read(reserva.getHospede().getId()));
        GregorianCalendar dataI = DateUtil.getGregorianCalendarDate(dataInicio);
        GregorianCalendar dataF = DateUtil.getGregorianCalendarDate(dataFim);

        if (DateUtil.isValidTimeGap(dataInicio, dataFim)) {
            System.out.println("\nadicionando...\n");

            reserva.setDataInicio(dataI);
            reserva.setDataFim(dataF);

            if (reserva.getId() == 0) {
                ReservaDAO.create(reserva);
            } else {
                ReservaDAO.update(reserva);
            }
        }
        getResult().forwardTo(this).reservas();
    }

    public List<Reserva> reservas() {
        return ReservaDAO.getAll();
    }

    public void editar(Reserva reserva) {
        reserva = ReservaDAO.read(reserva.getId());
        result.include("reserva", reserva);
    }

    public void excluir(Reserva reserva) {
        ReservaDAO.delete(reserva.getId());
        getResult().forwardTo(this).reservas();
    }

    public void apartamentoHospedeFuncionario(Reserva reserva, String dataInicio, String dataFim, int editar, int internet) {
        result.include("dataInicio", dataInicio);
        result.include("dataFim", dataFim);
        result.include("hospedes", HospedeDAO.getAll());
        List<Apartamento> apartamentos = Util.getVacant(reserva.getId(), ReservaDAO.getAll(), ApartamentoDAO.getAll(), dataInicio, dataFim);
        result.include("apartamentos", apartamentos);
        result.include("funcionarios", FuncionarioDAO.getAll());
        result.include("reserva", reserva);
        result.include("internet", internet);
        result.include("editar", editar);
    }

    public void concluir(Reserva reserva, String dataInicio, String dataFim) {
        if (reserva.getId() > 0) {
            reserva = ReservaDAO.read(reserva.getId());
        }

        reserva.setFuncionario(FuncionarioDAO.read(reserva.getFuncionario().getId()));
        reserva.setApartamento(ApartamentoDAO.read(reserva.getApartamento().getId()));
        reserva.setHospede(HospedeDAO.read(reserva.getHospede().getId()));
        result.include("dataInicio", dataInicio);
        result.include("dataFim", dataFim);
        result.include("reserva", reserva);
    }

    public void novoInternet() {
        List<Funcionario> funcionarios = FuncionarioDAO.getAll();
        Funcionario funcionario = null;

        for (Funcionario eachFuncionario : funcionarios) {
            if (INTERNET.equalsIgnoreCase(eachFuncionario.getNome())) {
                funcionario = eachFuncionario;
            }
        }

        result.include("funcionario", funcionario);
    }
}
