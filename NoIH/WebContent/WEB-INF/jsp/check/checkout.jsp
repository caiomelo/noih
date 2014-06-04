<%-- 
    Document   : checkout
    Created on : 31/05/2014, 18:09:26
    Author     : RodriguesMoises
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="despesas">
            <p align="center">
                Registro em nome de:<select name="registro.id">
                    <c:forEach var="registro" items="${registros}">
                        <option value="${registro.id}">${registro.hospede.nome}</option>
                    </c:forEach>
                </select>
                <br/>
                <input type="submit">
            </p>
        </form>
    </body>
</html>
