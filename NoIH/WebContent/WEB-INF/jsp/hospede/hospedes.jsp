<%-- 
    Document   : hospedes
    Created on : 22/04/2014, 21:26:09
    Author     : RodriguesMoises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hóspede</title>
    </head>
    <body>
        <table border="1" align="center">
            <tr>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="hospede" items="${hospedeList}">
                <tr>
                    <td>${hospede.nome}</td>
                    <td>${hospede.telefone}</td>
                    <td>${hospede.email}</td>
                    <td><a href="<c:url value="/hospede/editar"/>?hospede.id=${hospede.id}">Editar</a></td>
                    <td><a href="<c:url value="/hospede/excluir"/>?hospede.id=${hospede.id}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <p align="center"><a href="novo">Novo hospede</a></p>
        <p align="center"><a href="/NoIH">Início</a></p>

    </body>
</html>
