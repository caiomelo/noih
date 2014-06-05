<%--
    Document   : hospedeLocalizado
    Created on : Jun 4, 2014, 9:55:31 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da busca de hóspede</title>
    </head>
    <body>
        <c:if test="${valor > 0}">Hóspede ${nome} está no quarto de número ${apartamento}</c:if>
        <c:if test="${valor == 0}">Hóspede não localizado em nenhum quarto</c:if>
        <p align="center"><a href="/NoIH">Início</a></p>
    </body>
</html>
