<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="Stylesheet" href="<c:url value="/estilos/tela.css" />" type="text/css" media="screen" />
	<title>PSF - Biopatometria - Edita</title>
</head>
<body>
	
	<div id="wrapper">
		<form action="<c:url value="/biopatometria/edita/${biopatometria.id }"/>" method="post">
			<fieldset>
				<label for="edita_biopatometria_propriedade"
				<vraptor:hasErrors category="propriedade">class="vermelho"</vraptor:hasErrors>>Propriedade</label>
				<select id="edita_biopatometria_propriedade" name="biopatometria.propriedade.id"
				<vraptor:hasErrors category="propriedade">class="errado"</vraptor:hasErrors>>
					<c:if test="${biopatometria.propriedade != null and biopatometria.propriedade.id != null and biopatometria.propriedade.id > 0 }" >
						<option value="${biopatometria.propriedade.id }">${biopatometria.propriedade.nome }</option>
					</c:if>
					<option value="0">Selecione a propriedade</option>
					<c:forEach items="${propriedadeList }" var="propriedade">
						<option value="${propriedade.id }">${propriedade.nome }</option>
					</c:forEach>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="propriedade">  										  		
						<div>
							<vraptor:showErrors category="propriedade" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="edita_biopatometria_problema"
				<vraptor:hasErrors category="problema">class="vermelho"</vraptor:hasErrors>>Problema Diagnosticado</label>
				<select id="edita_biopatometria_problema" name="biopatometria.problema.id"
				<vraptor:hasErrors category="problema">class="errado"</vraptor:hasErrors>>
					<c:if test="${biopatometria.problema != null and biopatometria.problema.id != null and biopatometria.problema.id > 0 }" >
						<option value="${biopatometria.problema.id }">${biopatometria.problema.ocorrencia }</option>
					</c:if>
					<option value="0">Selecione o problema</option>
					<c:forEach items="${problemaList }" var="problema">
						<option value="${problema.id }">${problema.ocorrencia }</option>
					</c:forEach>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="problema">  										  		
						<div>
							<vraptor:showErrors category="problema" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
	
			<fieldset>
				<label for="edita_biopatometria_data"
				<vraptor:hasErrors category="data">class="vermelho"</vraptor:hasErrors>>Data</label> 
				<input id="edita_biopatometria_data" type="text" name="biopatometria.data"
					value='<fmt:formatDate value="${biopatometria.data }" pattern="dd/MM/yyyy" />' 
				<vraptor:hasErrors category="data">class="errado"</vraptor:hasErrors>/>
				
				<div class="erro">
					<vraptor:hasErrors category="data">  										  		
						<div>
							<vraptor:showErrors category="data" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="edita_biopatometria_up">UP</label> 
				<input id="edita_biopatometria_up" type="text" name="biopatometria.up" value="${biopatometria.up }" />
			</fieldset>
	
			<fieldset>
				<label for="edita_biopatometria_qtdAmostra">Quantidade da Amostra </label> 
				<input id="edita_biopatometria_qtdAmostra"type="text" name="biopatometria.qtdAmostra" value="${biopatometria.qtdAmostra }" />
			</fieldset>
	
			<fieldset>
				<label for="edita_biopatometria_qtdAfetado">Quantidade Afetada </label> 
				<input id="edita_biopatometria_qtdAfetado"type="text" name="biopatometria.qtdAfetado" value="${biopatometria.qtdAfetado }" />
			</fieldset>
	
			<fieldset>
				<label for="edita_biopatometria_grauSeveriadade"
				<vraptor:hasErrors category="grauSeveridade">class="vermelho"</vraptor:hasErrors>>Grau de Severidade</label> 
				<select id="edita_biopatometria_grauSeveridade" name="biopatometria.grauSeveridade"
				<vraptor:hasErrors category="grauSeveridade">class="errado"</vraptor:hasErrors>>
					<c:if test="${biopatometria.grauSeveridade != null and biopatometria.grauSeveridade != 0}">
						<option value="${biopatometria.grauSeveridade }">${biopatometria.grauSeveridade }</option>
					</c:if>
					<option value="0">Selecione o grau de severidade</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="grauSeveridade">  										  		
						<div>
							<vraptor:showErrors category="grauSeveridade" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<input type="hidden" name="_method" value="put" />
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>
	</div>
</body>
</html>