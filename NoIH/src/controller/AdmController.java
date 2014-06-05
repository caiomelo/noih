/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ApartamentoDAO;
import dao.RegistroDAO;
import dao.ReservaDAO;
import java.util.GregorianCalendar;
import java.util.List;
import model.Apartamento;
import model.Registro;
import model.Reserva;
import util.DateUtil;

/**
 *
 * @author Caio
 */
@Resource
public class AdmController {

    private Result result;

    public AdmController(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void ocupacao() {
    }

    public void taxaOcupacao(String data) {
        GregorianCalendar dataTaxa;
        List<Apartamento> apartamentos = ApartamentoDAO.getAll();
        float apes = apartamentos.size();

        if (data == null) {
            dataTaxa = new GregorianCalendar();
            data = dataTaxa.getTime().toString();
        } else {
            dataTaxa = DateUtil.getGregorianCalendarDate(data);
        }

        List<Reserva> reservas = ReservaDAO.getAll();

        float res = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getDataInicio().before(dataTaxa) && reserva.getDataFim().after(dataTaxa)) {
                res = res + 1;
            }
        }

        float taxa = res / apes;

        result.include("taxa", taxa);
        result.include("data", data);
    }

    public void opcoes() {
    }

    public void buscaHospede() {
    }

    public void hospedeLocalizado(String nome) {
        List<Registro> registros = RegistroDAO.getAll();
        int valor = 0;

        for (Registro registro : registros) {
            if (registro.getHospede().getNome().equalsIgnoreCase(nome) && registro.getStatus().equalsIgnoreCase(Registro.ABERTO)) {
                result.include("apartamento", registro.getApartamento().getNumero());
                result.include("nome", nome);
                valor = 1;
            }
        }
        result.include("valor", valor);
    }
}
