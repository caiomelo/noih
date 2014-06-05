<%-- 
    Document   : estorno
    Created on : 05/06/2014, 00:42:52
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
        <h4 align="center">Escolha o registro:</h4>
        <form action="servico" method="post">
            <p align="center"><select name="registro.id">
                <c:forEach var="registro" items="${registros}">
                    <option value="${registro.id}">${registro.hospede.nome}</option>
                </c:forEach>
            </select></p>
            <p align="center"><input type="submit"></p>
        </form>
    </body>
</html>
