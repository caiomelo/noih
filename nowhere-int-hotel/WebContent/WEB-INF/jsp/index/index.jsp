<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema PSF</title>
	<link href="<c:url value="/estilos/index.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="imgWrapper">
		<img src="<c:url value="/estilos/images/aquic.png" />" />
	</div>
	
	<div id="mid">
		<form action="<c:url value="/login" />" method="post">
			<fieldset>
			<label for="login_login" 
				<vraptor:hasErrors category="login">class="vermelho"</vraptor:hasErrors>>USUÁRIO</label> 
				<input id="login_login" type="text" name="login" value="${login }" 
				<vraptor:hasErrors category="login">class="errado"</vraptor:hasErrors>/>
		
			<div class="erro">
				<vraptor:hasErrors category="login">  										  		
					<div>
						<vraptor:showErrors category="login" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
			</fieldset>
			
			<fieldset>
			<label for="login_senha" 
				<vraptor:hasErrors category="senha">class="vermelho"</vraptor:hasErrors>>SENHA</label> 
				<input id="login_senha" type="text" name="senha" value="${senha }" 
				<vraptor:hasErrors category="senha">class="errado"</vraptor:hasErrors>/>
		
			<div class="erro">
				<vraptor:hasErrors category="senha">  										  		
					<div>
						<vraptor:showErrors category="senha" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
			</fieldset>
			
			<fieldset id="fSubmit"><input type="submit" value="Entrar" /></fieldset>
		</form>
	</div>
	<div id="footer">
		<p>© Copyright 2013 PSF Aquicultura, Inc. All rights reserved<br />Desenvolvido por e-Dea Jr.</p>
	</div>
</body>
</html>