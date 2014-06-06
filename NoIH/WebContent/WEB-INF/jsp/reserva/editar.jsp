<%--
    Document   : editar
    Created on : May 14, 2014, 11:39:45 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar reserva</title>
    </head>
    <h:body>
        <h:outputText value=" ${reserva.dataInicio.time}">Data de entrada:
            <f:formatDate value="${reserva.dataInicio.time}" pattern="dd/MM/yyyy"/>
        </h:outputText><br>
        <h:outputText value=" ${reserva.dataFim.time}">Data de saída:
            <f:formatDate value="${reserva.dataFim.time}" pattern="dd/MM/yyyy"/>
        </h:outputText><br>
        Apartamento: ${reserva.apartamento.numero}<br>
        Hóspede: ${reserva.hospede.nome}<br>
        <c:if test="${reserva.funcionario.nome ne 'Internet'}">
            Funcionário: ${reserva.funcionario.nome}
        </c:if>

        <form action="apartamentoHospedeFuncionario" method="post">
            <p align="center">
                De:<input type="text" name="dataInicio" value="${dataInicio}"><br/>
                Até:<input type="text" name="dataFim" value="${dataFim}"><br/>
                <input type="hidden" name="reserva.id" value="${reserva.id}">
                <input type="hidden" name="reserva.hospede.id" value="${reserva.hospede.id}">
                <input type="hidden" name="reserva.funcionario.id" value="${reserva.funcionario.id}">
                <input type="hidden" name="editar" value="1">
                <input type="hidden" name="internet" value="0">
                <input type="submit">
            </p>
        </form>
    </h:body>
</html>
