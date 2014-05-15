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
            <input type="hidden" name="hospede.id" value="${hospede}">
            <input type="hidden" name="reserva.id" value="${reserva}">
            Apartamento:
            <select name="apartamento.id">
                <c:forEach var="apartamento" items="${apartamentos}">
                    <option value="${apartamento.id}">Andar ${apartamento.andar} Apartamento ${apartamento.numero}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form>
    </body>
</html>
