<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="Stylesheet" href="<c:url value="/estilos/tela.css" />" type="text/css" media="screen" />
	<title>Tecnico Responsável - edita</title>
</head>
<body>
	<c:forEach items="${errors }" var="erro">
		${erro.category } - ${erro.message } <br />
	</c:forEach>

	<form action="<c:url value="/tecnicoResponsavel/edita/${tecnicoResponsavel.id }" />" method="post">
		<fieldset>
			<label for="edita_tecnicoResponsavel_nome"
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Nome</label> 
				<input id="edita_tecnicoResponsavel_nome" type="text" name="tecnicoResponsavel.nome" value="${tecnicoResponsavel.nome }" 
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
			<label for="edita_tecnicoResponsavel_formacao"
			<vraptor:hasErrors category="formacao">class="vermelho"</vraptor:hasErrors>>Formação</label> 
			<select id="edita_tecnicoResponsavel_formacao" name="tecnicoResponsavel.formacao.id"
				<vraptor:hasErrors category="formacao">class="errado"</vraptor:hasErrors>>
				<c:if test="${tecnicoResponsavel.formacao.id != null and tecnicoResponsavel.formacao.id > 0}">
					<option value="${tecnicoResponsavel.formacao.id }">${tecnicoResponsavel.formacao.nome }</option>
				</c:if>
				<option value="0">Selecione a formação</option>
				<c:forEach items="${formacaoList }" var="formacao">
					<option value="${formacao.id }">${formacao.nome }</option>
				</c:forEach>
			</select>
			<div class="erro">
				<vraptor:hasErrors category="formacao">  										  		
					<div>
						<vraptor:showErrors category="formacao" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
		
		<fieldset>
			<label for="edita_tecnicoResponsavel_especialidade1">Especialidade 1 </label>
			<select id="edita_tecnicoResponsavel_especialidade1" name="tecnicoResponsavel.especialidade1.id">
				<c:if test="${tecnicoResponsavel.especialidade1.id != null and tecnicoResponsavel.especialidade1.id > 0}">
					<option value="${tecnicoResponsavel.especialidade1.id }">${tecnicoResponsavel.especialidade1.nome }</option>
				</c:if>
				<option value="0">Selecione a especialidade</option>
				<c:forEach items="${especialidadeList }" var="especialidade">
					<option value="${especialidade.id }">${especialidade.nome }</option>
				</c:forEach>
			</select>
		</fieldset>
		
	
		<fieldset>
			<label for="edita_tecnicoResponsavel_especialidade2">Especialidade 2</label> 
			<select id="edita_tecnicoResponsavel_especialidade2" name="tecnicoResponsavel.especialidade2.id">
				<c:if test="${tecnicoResponsavel.especialidade2.id != null and tecnicoResponsavel.especialidade2.id > 0}">
					<option value="${tecnicoResponsavel.especialidade2.id }">${tecnicoResponsavel.especialidade2.nome }</option>
				</c:if>
				<option value="0">Selecione a especialidade</option>
				<c:forEach items="${especialidadeList }" var="especialidade">
					<option value="${especialidade.id }">${especialidade.nome }</option>
				</c:forEach>
			</select>
		</fieldset>
			
		<fieldset>
			<label for="edita_tecnicoResponsavel_telefone">Telefone</label> <input
				type="text" name="tecnicoResponsavel.telefone" value="${tecnicoResponsavel.telefone }" />
		</fieldset>
			
		<fieldset>
			<label for="edita_tecnicoResponsavel_email">E-mail</label> <input
				type="text" name="tecnicoResponsavel.email" value="${tecnicoResponsavel.email }" />
		</fieldset>
		<input type="hidden" name="_method" value="put"/>
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>