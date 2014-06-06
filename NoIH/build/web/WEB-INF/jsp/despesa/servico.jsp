<%-- 
    Document   : servico
    Created on : 05/06/2014, 01:27:42
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
        <h4 align="center">Escolha a despesa:</h4>
        <form action="estornado" method="post">
            <input type="hidden" name="registro.id" value="${registro.id}">
            <p align="center"><select name="despesa.id">
                <c:forEach var="despesa" items="${despesas}">
                    <option value="${despesa.id}">${despesa.servico.nome}</option>
                </c:forEach>
            </select></p>
            <p align="center"><input type="submit"></p>
        </form>
    </body>
</html>
