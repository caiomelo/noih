<%--
    Document   : apartamentoHospedeFuncionario
    Created on : May 14, 2014, 11:50:50 PM
    Author     : Caio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <select name="reserva.apartamento.id">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">${apartamento.numero}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <c:choose>
                <c:when test="${editar == 0}">
                    Hóspede:
                    <select name="reserva.hospede.id">
                        <c:forEach var="hospede" items="${hospedes}">
                            <option value="${hospede.id}">${hospede.nome}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <c:choose>
                        <c:when test="${internet == 0}">
                            <br>
                            Funcionário:
                            <select name="reserva.funcionario.id">
                                <c:forEach var="funcionario" items="${funcionarios}">
                                    <option value="${funcionario.id}">${funcionario.nome}</option>
                                </c:forEach>
                            </select>
                        </c:when>
                    </c:choose>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${editar == 1}">
                    <input type="hidden" name="reserva.hospede.id" value="${reserva.hospede.id}">
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${internet == 1 || editar == 1}">
                    <input type="hidden" name="reserva.funcionario.id" value="${reserva.funcionario.id}">
                </c:when>
            </c:choose>
            <input type="hidden" name="reserva.id" value="${reserva.id}">
            <input type="submit">
        </form>
    </body>
</html>