<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="Stylesheet" href="<c:url value="/estilos/tela.css" />" type="text/css" media="screen" />
	<title>PSF - Problema Geral - edita</title>
</head>
<body>
	<form action="<c:url value="/problemaGeral/edita/${problemaGeral.id }"/>" method="post">
			<fieldset>
				Digite o tipo de problema
				<label for="edita_problemaGeral_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Ocorrência:  </label> 
				<input id="edita_problemaGeral_nome" type="text" name="problemaGeral.nome" value="${problemaGeral.nome }" 
					<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>/>
			
				<div class="erro">
					<vraptor:hasErrors category="nome">  										  		
						<div>
							<vraptor:showErrors category="nome" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<input type="hidden" name="_method" value="put"/>
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>
</body>
</html>