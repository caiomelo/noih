<%-- 
    Document   : editar
    Created on : May 14, 2014, 10:45:51 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar funcionário</title>
    </head>
    <body>
        <form action="adiciona" method="post">
            <p align="center">
                <input type="hidden" name="funcionario.id" value="${funcionario.id}">
                Nome:<input type="text" name="funcionario.nome" value="${funcionario.nome}"><br/>
                Cargo:<input type="text" name="funcionario.cargo" value="${funcionario.cargo}"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
