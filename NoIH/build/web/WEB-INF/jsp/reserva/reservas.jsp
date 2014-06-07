<%--
    Document   : reservas
    Created on : May 14, 2014, 11:39:29 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva</title>
    </head>
    <body>
        <table border="1" align="center">
            <h:column>
                <h:row>
                    <th>De</th>
                </h:row>
                <th>Até</th>
                <th>Hóspede</th>
                <th>Apartamento</th>
                <th>Editar</th>
                <th>Excluir</th>
            </h:column>
        </tr>
        <c:forEach var="reserva" items="${reservaList}">
            <td><h:outputText value="${reserva.dataInicio.time}">
                <f:formatDate value="${reserva.dataInicio.time}" pattern="yyyy-MM-dd"/>
            </h:outputText>  </td>
        <td><h:outputText value="${reserva.dataInicio.time}">
            <f:formatDate value="${reserva.dataFim.time}" pattern="yyyy-MM-dd"/>
        </h:outputText></td>
    <td>${reserva.hospede.nome}</td>
    <td>${reserva.apartamento.numero}</td>
    <td><a href="<c:url value="/reserva/editar"/>?reserva.id=${reserva.id}">Editar</a></td>
    <td><a href="<c:url value="/reserva/excluir"/>?reserva.id=${reserva.id}">Excluir</a></td>
</tr>
</c:forEach>
</table>
<p align="center"><a href="novoLocal">Nova reserva</a></p>
<p align="center"><a href="/NoIH">Início</a></p>
</body>
</html>
