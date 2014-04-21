<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="Stylesheet" href="<c:url value="/estilos/tela.css" />" type="text/css" media="screen" />
	<title>Município - edita </title>
</head>
<body>
	<form action="<c:url value="/municipio/edita/${municipio.id }" />" method="post">
		<fieldset>
			<label for="edita_municipio_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Nome</label> 
				<input type="text" name="municipio.nome" value="${municipio.nome }" 
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
			<label for="edita_municipio_uf"
			<vraptor:hasErrors category="uf">class="vermelho"</vraptor:hasErrors>>UF</label> 
			<select id="edita_municipio_uf" name="municipio.uf.id"
				<vraptor:hasErrors category="uf">class="errado"</vraptor:hasErrors>>
				<c:if test="${municipio.uf.id != null and municipio.uf.id > 0}">
					<option value="${municipio.uf.id }">${municipio.uf.nome } - ${municipio.uf.sigla }</option>
				</c:if>
				<option value="0">Selecione a UF</option>
				<c:forEach items="${ufList }" var="uf">
					<option value="${uf.id }">${uf.nome } - ${uf.sigla }</option>
				</c:forEach>
			</select>
			
			<div class="erro">
				<vraptor:hasErrors category="uf">  										  		
					<div>
						<vraptor:showErrors category="uf" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
		
		<input type="hidden" name="_method" value="put"/>
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>