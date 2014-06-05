<%-- 
    Document   : servicos
    Created on : 04/06/2014, 23:31:52
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
        <h4 align="center">Servicos por ordem de faturamento no mês passado:</h4>
        
        
        <table border="1" align="center">
            <tr>
                <th>Nome</th>
                <th>Total</th>
            </tr>
            <c:forEach var="servico" items="${servicos}">
                <tr>
                    <td>${servico.nome}</td>
                    <td>${servico.totalMesAnterior}</td>
                </tr>
            </c:forEach>
    </body>
</html>
