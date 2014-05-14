<%-- 
    Document   : novo
    Created on : May 14, 2014, 7:12:02 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo apartamento</title>
    </head>
    <body>
        <form action="adiciona" method="post">
            <p align="center">
                Andar:<input type="text" name="apartamento.andar"><br/>
                Número:<input type="text" name="apartamento.numero"><br/>
                Tipo:<input type="text" name="apartamento.tipo"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
