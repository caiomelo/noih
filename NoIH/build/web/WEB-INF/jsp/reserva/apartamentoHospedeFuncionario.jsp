<%--
    Document   : apartamentoHospedeFuncionario
    Created on : May 14, 2014, 11:50:50 PM
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
            <input type="hidden" name="dataInicio" value="${dataInicio}">
            <input type="hidden" name="dataFim" value="${dataFim}">
            Apartamento:
            <select name="apartamentoId">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">${apartamento.numero}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            Hóspede:
            <select name="hospedeId">
                <c:forEach var="hospede" items="${hospedes}">
                    <option value="${hospede.id}">${hospede.nome}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            Funcionário:
            <select name="funcionarioId">
                <c:forEach var="funcionario" items="${funcionarios}">
                    <option value="${funcionario.id}">${funcionario.nome}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="reservaId" value="${reservaId}">
            <input type="submit">
        </form>
    </body>
</html>