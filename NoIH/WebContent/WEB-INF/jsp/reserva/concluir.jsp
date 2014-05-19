<%--
    Document   : conclui-reserva
    Created on : May 14, 2014, 11:51:03 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva concluída</title>
    </head>
    <body>
        Data de entrada: ${dataInicio} <br>
        Data de saída: ${dataFim}<br>
        Apartamento: ${reserva.apartamento.numero}<br>
        Hóspede: ${reserva.hospede.nome}<br>
        Funcionário ${reserva.funcionario.nome}

        <form action="adiciona" method="post">
            <input type="hidden" name="reserva.id" value="${reserva.id}">
            <input type="hidden" name="dataInicio" value="${dataInicio}">
            <input type="hidden" name="dataFim" value="${dataFim}">
            <input type="hidden" name="funcId" value="${reserva.funcionario.id}">
            <input type="hidden" name="apeId" value="${reserva.apartamento.id}">
            <input type="hidden" name="hospId" value="${reserva.hospede.id}">
            <input type="submit">
        </form>

    </body>
</html>
