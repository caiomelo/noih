/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import model.*;
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
        float den = 0;

        if (data.equalsIgnoreCase("")) {
            dataTaxa = new GregorianCalendar();
            data = dataTaxa.getTime().toString();
        } else {
            dataTaxa = DateUtil.getGregorianCalendarDate(data);
        }

        if (dataTaxa.before(new GregorianCalendar())) {
            List<Registro> registros = RegistroDAO.getAll();
            for (Registro registro : registros) {
                if ((Registro.FECHADO.equalsIgnoreCase(registro.getStatus()) && registro.getCheckin().before(dataTaxa) && registro.getCheckout().after(dataTaxa))
                        || (Registro.ABERTO.equalsIgnoreCase(registro.getStatus()) && registro.getCheckin().before(dataTaxa))) {
                    den = den + 1;
                }
            }
        } else {
            List<Reserva> reservas = ReservaDAO.getAll();
            for (Reserva reserva : reservas) {
                if (reserva.getDataInicio().before(dataTaxa) && reserva.getDataFim().after(dataTaxa)) {
                    den = den + 1;
                }
            }
        }

        float taxa = den / apes;

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

    public void servicos() {
        ArrayList<Servico> servicos = ServicoDAO.getAll();
        for (Servico s : servicos) {
            ArrayList<Despesa> despesas = DespesaDAO.getAllFromServicoInLastMonth(s.getId());
            for (Despesa d : despesas) {
                s.setTotalMesAnterior(s.getTotalMesAnterior() + d.getValor());
            }
        }

        Servico[] array = new Servico[servicos.size()];
        for (int i = 0; i < servicos.size(); i++) {
            array[i] = servicos.get(i);
        }
        result.include("servicos", bubbleSort(array));
    }

    private Servico[] bubbleSort(Servico[] servicos) {
        for (int i = 1; i < servicos.length; i++) {
            for (int j = 0; j < servicos.length - i; j++) {
                if (servicos[j].getValor() < servicos[j + 1].getValor()) {
                    Servico s = servicos[j];
                    servicos[j] = servicos[j + 1];
                    servicos[j + 1] = s;
                }
            }
        }

        return servicos;
    }
}
