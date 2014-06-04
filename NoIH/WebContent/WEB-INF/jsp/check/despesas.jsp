<%-- 
    Document   : despesas
    Created on : 01/06/2014, 12:39:42
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
        <form action="registroFechado">
            <input type="hidden" name="registro.id" value="${registro.id}">
            <p align="center">
                Registro em nome de: ${registro.hospede.nome}<br/>
                Despesas:
                <table border="1" align="center">
                    <tr><th>Valor</th><th>Servico</th><th>Data</th></tr>
                    <c:forEach var="despesa" items="${despesas}">
                    <tr>
                        <td>${despesa.valor}</td>
                        <td>${despesa.servico.nome}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy hh:mm" value="${despesa.dataHora.time}"/></td>
                    </tr>
                    </c:forEach>
                    <p align="center">Total: ${registro.totalConta}</p>
                </table>
                <br/>
                
                <p align="center"><input type="submit" value="Checkout"></p>
            </p>
        </form>
    </body>
</html>
