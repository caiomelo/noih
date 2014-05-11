<%-- 
    Document   : adicionado
    Created on : 19/12/2013, 01:49:40
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
        <h2>Comentario adicionado!</h2>
        <table>
        <c:forEach var="comentario" items="${comentarioList}">
            <tr>
                <td>${comentario.comentario}</td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html> 
