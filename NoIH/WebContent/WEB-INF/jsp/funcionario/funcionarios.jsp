<%-- 
    Document   : funcionarios
    Created on : May 14, 2014, 10:45:44 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionário</title>
    </head>
    <body>
        <table border="1" align="center">
            <tr>
                <th>Nome</th>
                <th>Cargo</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="funcionario" items="${funcionarioList}">
                <tr>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.cargo}</td>
                    <td><a href="<c:url value="/funcionario/editar"/>?funcionario.id=${funcionario.id}">Editar</a></td>
                    <td><a href="<c:url value="/funcionario/excluir"/>?funcionario.id=${funcionario.id}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <p align="center"><a href="novo">Novo funcionário</a></p>
        <p align="center"><a href="/NoIH">Início</a></p>

    </body>
</html>
