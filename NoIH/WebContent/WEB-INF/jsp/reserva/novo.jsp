<%--
    Document   : novo
    Created on : May 14, 2014, 11:39:35 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova reserva</title>
    </head>
    <body>
        <form action="apartamentos" method="post">
            <p align="center">
                <input type="hidden" name="reserva.id">
                De:<input type="text" name="dataInicio" value="${dataInicio}"><br/>
                Até:<input type="text" name="dataFim" value="${dataFim}"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
