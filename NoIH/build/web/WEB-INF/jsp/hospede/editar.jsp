<%--
    Document   : editar
    Created on : 10/05/2014, 20:39:24
    Author     : RodriguesMoises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="adiciona" method="post">
            <p align="center">
                <input type="hidden" name="hospede.id" value="${hospede.id}">
                Nome:<input type="text" name="hospede.nome" value="${hospede.nome}"><br/>
                Telefone:<input type="text" name="hospede.telefone" value="${hospede.telefone}"><br/>
                Email:<input type="text" name="hospede.email" value="${hospede.email}"><br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
