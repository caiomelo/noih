<%-- 
    Document   : temaCadastrado
    Created on : 19/12/2013, 13:59:07
    Author     : RodriguesMoises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Tema Cadastrado:</h2>
        <c:out value="${tema.tema}"/>
    </body>
</html>
