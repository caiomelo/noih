<%--
    Document   : buscaHospede
    Created on : Jun 4, 2014, 9:50:13 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de hóspede pelo nome</title>
    </head>
    <body>
        <form action="hospedeLocalizado" method="post">
            <p align="center">
                Nome do hóspede:<input type="text" name="nome"><br/>
                <input type="submit">
            </p>
            <p align="center"><a href="/NoIH">Início</a></p>
        </form>
    </body>
</html>
