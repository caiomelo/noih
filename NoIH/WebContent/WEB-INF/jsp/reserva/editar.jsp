<%-- 
    Document   : editar
    Created on : May 14, 2014, 11:39:45 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar reserva</title>
    </head>
    <body>
        <form action="adiciona" method="post">
            <p align="center">
                <input type="hidden" name="reserva.id" value="${reserva.id}">
                De:<input type="datetime" name="reserva.dataInicio" value="${reserva.dataInicio}"><br/>
                Até:<input type="date" name="reserva.dataFim" value="${reserva.dataFim}"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
