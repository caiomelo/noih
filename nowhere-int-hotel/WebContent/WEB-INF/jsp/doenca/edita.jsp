<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PSF - Doenca - Edição</title>
	<link rel="Stylesheet" href="<c:url value="/estilos/tela.css" />" type="text/css" media="screen" />
</head>
<body>

	<form action="<c:url value="/doenca/edita/${doenca.id }" />" method="post">
		<fieldset>
			<label for="edita_doenca_nome"
			<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Doença</label> 
				<input type="text" name="doenca.nome" value="${doenca.nome }" 
			<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>/>
			
			<div class="erro">
				<vraptor:hasErrors category="nome">  										  		
					<div><vraptor:showErrors category="nome" /></div>  																	        	
				</vraptor:hasErrors>
			</div>
			
		</fieldset>
		
		
		<fieldset>
			<label for="edita_doenca_especialista">Especialista</label> <input
				type="text" name="doenca.especialista"
				value="${doenca.especialista }" />
		</fieldset>

		<fieldset>
			<label for="edita_doenca_observacao">Observação</label> <input
				type="text" name="doenca.observacao" value="${doenca.observacao }" />
		</fieldset>
		<input type="hidden" name="_method" value="put" />
		<input type="submit" value="Enviar" />

	</form>
</body>
</html>