<%-- 
    Document   : servicos
    Created on : 22/04/2014, 21:26:09
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
        <table border="1" align="center">
            <tr>
                <th>Nome</th>
                <th>Tipo</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="servico" items="${servicoList}">
                <tr>
                    <td>${servico.nome}</td>
                    <td>${servico.valor}</td>
                    <td><a href="<c:url value="/servico/editar"/>?servico.id=${servico.id}">Editar</a></td>
                    <td><a href="<c:url value="/servico/excluir"/>?servico.id=${servico.id}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <p align="center"><a href="novo">Novo serviço</a></p>
    </body>
</html>
