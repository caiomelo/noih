<%-- 
    Document   : seleciona-quarto
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
        <form action="concluir" method="post">
            <input type="hidden" name="hospede.id" value="${hospede}">
            Apartamento:
            <select name="apartamento.id">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">Apartamento ${apartamento.numero}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form>
    </body>
</html>