<%--
    Document   : novo
    Created on : May 14, 2014, 11:39:35 PM
    Author     : Caio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(function() {
                $("#de").datepicker({
                    minDate: 0,
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: 'yy-mm-dd',
                    onClose: function(selectedDate) {
                        var minDate = new Date(Date.parse(selectedDate));
                        minDate.setDate(date.getDate())
                        $("#ate").datepicker("option", "minDate", minDate);
                    }
                });
                $("#ate").datepicker({
                    minDate: +1,
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: 'yy-mm-dd',
                    onClose: function(selectedDate) {
                        var maxDate = new Date(Date.parse(selectedDate));
                        maxDate.setDate(maxDate.getDate())
                        $("#de").datepicker("option", "maxDate", maxDate);
                    }
                });
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova reserva</title>
    </head>
    <body>
        <form action="apartamentoHospedeFuncionario" method="post">
            <p align="center">
                De:<input type="text" id="de" name="dataInicio"><br/>
                Até:<input type="text" id="ate" name="dataFim"><br/>
                <input type="hidden" name="reserva.id" value="${reserva.id}">
                <input type="hidden" name="editar" value="0">
                <input type="hidden" name="internet" value="0">
                <input type="submit">
            </p>
        </form>
    </body>
</html>
