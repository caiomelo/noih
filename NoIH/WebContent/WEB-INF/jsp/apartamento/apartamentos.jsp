<%-- 
    Document   : apartamentos
    Created on : May 14, 2014, 7:11:47 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apartamento</title>
    </head>
    <body>
        <table border="1" align="center">
            <tr>
                <th>Andar</th>
                <th>Número</th>
                <th>Tipo</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="apartamento" items="${apartamentoList}">
                <tr>
                    <td>${apartamento.andar}</td>
                    <td>${apartamento.numero}</td>
                    <td>${apartamento.tipo}</td>
                    <td><a href="<c:url value="/apartamento/editar"/>?apartamento.id=${apartamento.id}">Editar</a></td>
                    <td><a href="<c:url value="/apartamento/excluir"/>?apartamento.id=${apartamento.id}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <p align="center"><a href="novo">Novo apartamento</a></p>
        <p align="center"><a href="/NoIH">Início</a></p>
    </body>
</html>