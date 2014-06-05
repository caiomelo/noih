<%-- 
    Document   : registroFechado
    Created on : 03/06/2014, 22:59:40
    Author     : RodriguesMoises
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 align="center">Registro de ${registro.hospede.nome} encerrado!</h4>
        <p align="center">Valor total de: ${registro.totalConta}</p>
        <p align="center"><a href="/NoIH">Voltar</a></p>
    </body>
</html>
