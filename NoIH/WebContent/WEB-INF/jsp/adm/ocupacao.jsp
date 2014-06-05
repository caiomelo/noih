<%--
    Document   : ocupacao
    Created on : Jun 4, 2014, 4:49:55 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verificar taxa de ocupação</title>
    </head>
    <body>
        <form action="taxaOcupacao" method="post">
            <p align="center">
                Data a ser verificada:<input type="text" name="data" value="${data}"><br/>
                <input type="submit">
            </p>
        </form>
        <p align="center"><a href="/NoIH">Início</a></p>
    </body>
</html>
