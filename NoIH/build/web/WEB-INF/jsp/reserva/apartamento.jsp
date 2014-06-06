<%--
    Document   : apartamento
    Created on : May 19, 2014, 1:41:12 AM
    Author     : Caio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecione apartamento</title>
    </head>
    <body>
        Apartamentos disponíveis no periodo<br>
        De: ${dataInicio}<br>
        Até: ${dataFim}<br>
        <br>
        <form action="concluir" method="post">
            <input type="hidden" name="reserva.id" value="${reserva.id}">
            <input type="hidden" name="dataInicio" value="${dataInicio}">
            <input type="hidden" name="dataFim" value="${dataFim}">
            <input type="hidden" name="reserva.hospede.id" value="${reserva.hospede.id}">
            <input type="hidden" name="reserva.funcionario.id" value="${reserva.funcionario.id}">
            Apartamento:
            <select name="reserva.apartamento.id">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">${apartamento.numero}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit">
        </form>
    </body>
</html>