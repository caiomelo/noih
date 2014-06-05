<%-- 
    Document   : editar
    Created on : May 14, 2014, 7:11:56 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar apartamento</title>
    </head>
    <body>
        <form action="adiciona" method="post">
            <p align="center">
                <input type="hidden" name="apartamento.id" value="${apartamento.id}">
                Andar:<input type="text" name="apartamento.andar" value="${apartamento.andar}"><br/>
                Número:<input type="text" name="apartamento.numero" value="${apartamento.numero}"><br/>
                Tipo:<input type="text" name="apartamento.tipo" value="${apartamento.tipo}"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
