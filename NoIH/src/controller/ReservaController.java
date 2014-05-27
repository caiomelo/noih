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
import java.util.List;
import model.Apartamento;
import model.Reserva;
import util.DateUtil;

/**
 *
 * @author Caio
 */
@Resource
public class ReservaController {

    private Result result;

    public ReservaController(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void novo() {
    }

    public void adiciona(Reserva reserva, long apeId, long funcId, long hospId, String dataInicio, String dataFim) {
        reserva.setFuncionario(FuncionarioDAO.read(funcId));
        reserva.setApartamento(ApartamentoDAO.read(apeId));
        reserva.setHospede(HospedeDAO.read(hospId));
        reserva.setDataInicio(DateUtil.getGregorianCalendarDate(dataInicio));
        reserva.setDataFim(DateUtil.getGregorianCalendarDate(dataFim));

        if (DateUtil.isValidTimeGap(dataInicio, dataFim)) {
            System.out.println("\nadicionando...\n");
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
        result.include(reserva);
    }

    public void excluir(Reserva reserva) {
        ReservaDAO.delete(reserva.getId());
        getResult().forwardTo(this).reservas();
    }

    public void apartamentoHospedeFuncionario(long reservaId, String dataInicio, String dataFim) {
        result.include("dataInicio", dataInicio);
        result.include("dataFim", dataFim);
        result.include("hospedes", HospedeDAO.getAll());
        List<Apartamento> apartamentos = Util.getVacant(reservaId, ReservaDAO.getAll(), ApartamentoDAO.getAll(), dataInicio, dataFim);
        result.include("apartamentos", apartamentos);
        result.include("funcionarios", FuncionarioDAO.getAll());
        result.include("reservaId", reservaId);
    }

    public void apartamento(long reservaId, String dataInicio, String dataFim, long funcionarioId, long hospedeId) {
        result.include("dataInicio", dataInicio);
        result.include("dataFim", dataFim);
        result.include("hospedeId", hospedeId);
        result.include("funcionarioId", funcionarioId);
        List<Apartamento> apartamentos = Util.getVacant(reservaId, ReservaDAO.getAll(), ApartamentoDAO.getAll(), dataInicio, dataFim);
        result.include("apartamentos", apartamentos);
        result.include("reservaId", reservaId);
    }

    public void concluir(long reservaId, long apartamentoId, long hospedeId, long funcionarioId, String dataInicio, String dataFim) {
        Reserva reserva = ReservaDAO.read(reservaId);

        if (reserva == null) {
            reserva = new Reserva();
            reserva.setId(reservaId);
        }
        reserva.setFuncionario(FuncionarioDAO.read(funcionarioId));
        reserva.setApartamento(ApartamentoDAO.read(apartamentoId));
        reserva.setHospede(HospedeDAO.read(hospedeId));
        result.include("dataInicio", dataInicio);
        result.include("dataFim", dataFim);
        result.include("reserva", reserva);
    }
}
