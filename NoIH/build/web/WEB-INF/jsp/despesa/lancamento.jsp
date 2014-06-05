<%-- 
    Document   : lancamento
    Created on : 05/06/2014, 00:42:38
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
        <form action="lancado" method="post">
            <p align="center">Registro:</p>
                <p align="center"><select name="registro.id">
                    <c:forEach var="registro" items="${registros}">
                        <option value="${registro.id}">${registro.hospede.nome} em Apartamento ${registro.apartamento.numero}</option>
                    </c:forEach>
                </select></p>
                
            <p align="center">Serviço:</p>
                <p align="center"><select name="servico.id">
                    <c:forEach var="servico" items="${servicos}">
                        <option value="${servico.id}">${servico.nome}</option>
                    </c:forEach>
                </select></p>
                
                <p align="center"><input type="submit"></p>
        </form>
    </body>
</html>
