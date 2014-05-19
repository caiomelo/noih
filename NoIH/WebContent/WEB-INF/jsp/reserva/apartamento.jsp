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
            <input type="hidden" name="reservaId" value="${reservaId}">
            <input type="hidden" name="dataInicio" value="${dataInicio}">
            <input type="hidden" name="dataFim" value="${dataFim}">
            <input type="hidden" name="hospedeId" value="${hospedeId}">
            <input type="hidden" name="funcionarioId" value="${funcionarioId}">
            Apartamento:
            <select name="apartamentoId">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">${apartamento.numero}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit">
        </form>
    </body>
</html>