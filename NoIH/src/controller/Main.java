/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import dao.*;
import java.util.ArrayList;

/**
 *
 * @author RodriguesMoises
 */
public class Main {
    public static void main(String[] args) {
        //----------------------------- ApartamentoDAO TESTS! -----------------------------
        /*Apartamento apartamento = new Apartamento();
        Util.fillObject(apartamento);
        System.out.println(apartamento);
        ApartamentoDAO.create(apartamento);*/

        /*Apartamento apartamento = ApartamentoDAO.read(1);
        System.out.println(apartamento);*/

        /*Apartamento apartamento = ApartamentoDAO.read(1);
        apartamento.setAndar(7);
        apartamento.setNumero(711);
        apartamento.setTipo("suite");
        ApartamentoDAO.update(apartamento);*/

        /*ApartamentoDAO.delete(24);*/

        /*ArrayList<Apartamento> apartamentos = ApartamentoDAO.getAll();
        for(Apartamento apartamento : apartamentos)
        {
                System.out.println(apartamento);
        }*/


        //----------------------------- DespesaDAO TESTS! -----------------------------
        /*Despesa despesa = new Despesa();
        Util.fillObject(despesa);
        despesa.getRegistro().setId(1);
        despesa.getServico().setId(1);
        System.out.println(despesa);
        DespesaDAO.create(despesa);*/

        /*Despesa despesa = DespesaDAO.read(3);
        System.out.println(despesa);*/

        /*Despesa despesa = DespesaDAO.read(4);
        despesa.setValor(50);
        DespesaDAO.update(despesa);*/

        /*DespesaDAO.delete(3);*/

        /*ArrayList<Despesa> despesas = DespesaDAO.getAll();
        for(Despesa despesa : despesas)
        {
            System.out.println(despesa);
        }*/


        //----------------------------- FuncionarioDAO TESTS! -----------------------------
        /*Funcionario funcionario = new Funcionario();
        Util.fillObject(funcionario);
        System.out.println(funcionario);
        FuncionarioDAO.create(funcionario);*/

        /*Funcionario funcionario = FuncionarioDAO.read(1);
        System.out.println(funcionario);*/

        /*Funcionario funcionario = FuncionarioDAO.read(1);
        funcionario.setCargo("recepcionista");
        funcionario.setLogin("recep");
        funcionario.setNome("func");
        funcionario.setSenha("1234");
        FuncionarioDAO.update(funcionario);*/

        /*FuncionarioDAO.delete(2);*/

        /*ArrayList<Funcionario> funcionarios = FuncionarioDAO.getAll();
        for(Funcionario funcionario : funcionarios)
        {
                System.out.println(funcionario);
        }*/


        //----------------------------- HospedeDAO TESTS! -----------------------------
        /*Hospede hospede = new Hospede();
        Util.fillObject(hospede);
        System.out.println(hospede);
        HospedeDAO.create(hospede);*/

        /*Hospede hospede = HospedeDAO.read(1);
        System.out.println(hospede);*/

        /*Hospede hospede = HospedeDAO.read(1);
        hospede.setNome("italo");
        hospede.setTelefone("123456");
        hospede.setEmail("krateka");
        HospedeDAO.update(hospede);*/

        /*HospedeDAO.delete(22);*/

        /*ArrayList<Hospede> hospedes = HospedeDAO.getAll();
        for(Hospede hospede : hospedes)
        {
            System.out.println(hospede);
        }*/


        //----------------------------- HotelDAO TESTS! -----------------------------
        /*Hotel hotel = new Hotel();
        Util.fillObject(hotel);
        System.out.println(hotel);
        HotelDAO.create(hotel);*/

        /*Hotel hotel = HotelDAO.read(1);
        System.out.println(hotel);*/

        /*Hotel hotel = HotelDAO.read(1);
        hotel.setNome("NoIH");
        HotelDAO.update(hotel);*/

        /*HotelDAO.delete(2);*/

        /*ArrayList<Hotel> hotels = HotelDAO.getAll();
        for(Hotel hotel : hotels)
        {
            System.out.println(hotel);
        }*/


        //----------------------------- RegistroDAO TESTS! -----------------------------
        /*Registro registro = new Registro();
        Util.fillObject(registro);
        registro.getApartamento().setId(22);
        registro.getFuncionario().setId(1);
        registro.getHospede().setId(1);
        registro.getReserva().setId(1);
        System.out.println(registro);
        RegistroDAO.create(registro);*/

        /*Registro registro = RegistroDAO.read(1);
        System.out.println(registro);*/

        /*Registro registro = RegistroDAO.read(1);        
        registro.getApartamento().setId(22);
        registro.getFuncionario().setId(1);
        registro.getHospede().setId(1);
        registro.getReserva().setId(1);
        System.out.println(registro);
        RegistroDAO.update(registro);*/

        /*RegistroDAO.delete(2);*/

        /*ArrayList<Registro> registros = RegistroDAO.getAll();
        for(Registro registro : registros)
        {
            System.out.println(registro);
        }*/


        //----------------------------- ReservaDAO TESTS! -----------------------------
        /*Reserva reserva = new Reserva();
        Util.fillObject(reserva);
        reserva.getApartamento().setId(1);
        reserva.getFuncionario().setId(1);
        reserva.getHospede().setId(1);
        System.out.println(reserva);
        ReservaDAO.create(reserva);*/

        /*Reserva reserva = ReservaDAO.read(1);
        System.out.println(reserva);*/

        /*Reserva reserva = ReservaDAO.read(1);
        reserva.setApartamento(ApartamentoDAO.read(22));
        ReservaDAO.update(reserva);*/

        /*ReservaDAO.delete(2);*/

        /*ArrayList<Reserva> reservas = ReservaDAO.getAll();
        for(Reserva reserva : reservas)
        {
            System.out.println(reserva);
        }*/


        //----------------------------- ServicoDAO TESTS! -----------------------------
        /*Servico servico = new Servico();
        Util.fillObject(servico);
        System.out.println(servico);
        ServicoDAO.create(servico);*/

        /*Servico servico = ServicoDAO.read(1);
        System.out.println(servico);*/

        /*Servico servico = ServicoDAO.read(1);
        servico.setNome("sauna");
        servico.setTipo("consumable");
        servico.setValor(100);
        ServicoDAO.update(servico);*/

        /*ServicoDAO.delete(24);*/

        /*ArrayList<Servico> servicos = ServicoDAO.getAll();
        for(Servico servico : servicos)
        {
                System.out.println(servico);
        }*/
    }
}
