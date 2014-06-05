<%-- 
    Document   : hospedereserva
    Created on : 14/05/2014, 20:12:40
    Author     : RodriguesMoises
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="apartamento" method="post">
            <p align="center">Hóspede:</p>
            <p align="center"><select name="hospede.id">
                <c:forEach var="hospede" items="${hospedes}">
                    <option value="${hospede.id}">${hospede.nome}</option>
                </c:forEach>
            </select></p>
            
            <p align="center">Reserva em nome de:</p>
            <p align="center"><select name="reserva.id">
                <option value="0">Sem reserva</option>
                <c:forEach var="reserva" items="${reservas}">
                    <option value="${reserva.id}">${reserva.hospede.nome}</option>
                </c:forEach>
            </select></p>
            
            <p align="center"><input type="submit"></p>
        </form>
    </body>
</html>
