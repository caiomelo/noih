<%-- 
    Document   : novo
    Created on : May 14, 2014, 10:45:56 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo funcionário</title>
    </head>
    <body>
        <form action="adiciona" method="post">
            <p align="center">
                Nome:<input type="text" name="funcionario.nome"><br/>
                Cargo:<input type="text" name="funcionario.cargo"><br/>
                Login:<input type="text" name="funcionario.login"><br/>
                Senha:<input type="password" name="funcionario.senha"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
