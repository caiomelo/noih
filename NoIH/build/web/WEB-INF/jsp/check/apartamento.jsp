<%-- 
    Document   : apartamento
    Created on : 14/05/2014, 23:38:24
    Author     : RodriguesMoises
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="checkin" method="post">
            <input type="hidden" name="hospede.id" value="${hospede.id}">
            <input type="hidden" name="reserva.id" value="${reserva.id}">
            <p align="center">Apartamento:</p>
            <p align="center"><select name="apartamento.id">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">Andar ${apartamento.andar} Apartamento ${apartamento.numero}</option>
                </c:forEach>
            </select></p>
            <p align="center">Data prevista para checkout:</p>
            <p align="center"><input type="text" name="reserva.dataFim" value="${dataFim}"></p>
            <p align="center"><input type="submit"></p>
        </form>
    </body>
</html>
