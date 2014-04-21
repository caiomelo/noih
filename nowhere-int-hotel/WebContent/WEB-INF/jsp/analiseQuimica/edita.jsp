<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="Stylesheet" href="<c:url value="/estilos/tela.css" />" type="text/css" media="screen" />
	<title>PSF - Análise Química - novo</title>
</head>
<body>
	<c:forEach items="${errors }" var="erro">
		${erro.category } - ${erro.message } <br />
	</c:forEach>
	<div id="wrapper">
		<form action="<c:url value="/analiseQuimica/edita/${analiseQuimica.id }"/>" method="post">	
		
			<fieldset>
				<label for="edita_analiseQuimica_propriedade"
				<vraptor:hasErrors category="propriedade">class="vermelho"</vraptor:hasErrors>>Propriedade</label>
				<select id="edita_analiseQuimica_propriedade" name="analiseQuimica.propriedade.id"
				<vraptor:hasErrors category="propriedade">class="errado"</vraptor:hasErrors>>
					<c:if test="${analiseQuimica.propriedade != null and analiseQuimica.propriedade.id != null 
							and analiseQuimica.propriedade.id > 0 }" >
						<option value="${analiseQuimica.propriedade.id }">${analiseQuimica.propriedade.nome }</option>
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
				<label for="edita_analiseQuimica_data"
				<vraptor:hasErrors category="data">class="vermelho"</vraptor:hasErrors>>Data </label> 
				<input id="edita_analiseQuimica_data" type="text" 
					name="analiseQuimica.data" value='<fmt:formatDate value="${analiseQuimica.data }" pattern="dd/MM/yyyy" />' 
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
				<label for="edita_analiseQuimica_amonia">Amonia</label> 
				<input id="edita_analiseQuimica_amonia" type="text" name="analiseQuimica.amonia" value="${analiseQuimica.amonia }" />
			</fieldset>
				
			<fieldset>
				<label for="edita_analiseQuimica_nitrito">Nitrito</label> 
				<input id="edita_analiseQuimica_nitrito" type="text" name="analiseQuimica.nitrito" value="${analiseQuimica.nitrito }" />
			</fieldset>
			
			<fieldset>
				<label for="edita_analiseQuimica_nitrato">Nitrato</label> 
				<input id="edita_analiseQuimica_nitrato" type="text" name="analiseQuimica.nitrato" value="${analiseQuimica.nitrato }" />
			</fieldset>
			
			<fieldset>
				<label for="edita_analiseQuimica_nTotal">Ntotal</label> 
				<input id="edita_analiseQuimica_nTotal" type="text" name="analiseQuimica.nTotal" value="${analiseQuimica.nTotal }" />
			</fieldset>
			
			<fieldset>
				<label for="edita_analiseQuimica_forforo">Fósforo</label> 
				<input id="edita_analiseQuimica_fosforo" type="text" name="analiseQuimica.fosforo" value="${analiseQuimica.fosforo }" />
			</fieldset>
			
			<fieldset>
				<label for="edita_analiseQuimica_dbo">Dbo</label> 
				<input id="edita_analiseQuimica_dbo" type="text" name="analiseQuimica.dbo" value="${analiseQuimica.dbo }" />
			</fieldset>
			
			<fieldset>
				<label for="edita_analiseQuimica_alcalinidade">Alcalinidade</label> 
				<input id="edita_analiseQuimica_alcalinidade" type="text" name="analiseQuimica.alcalinidade" value="${analiseQuimica.alcalinidade }" />
			</fieldset>
			
			<fieldset>
				<label for="edita_analiseQuimica_solidosSusp">Sólidos Suspensão</label> 
				<input id="edita_analiseQuimica_solidosSusp" type="text" name="analiseQuimica.solidosSusp" value="${analiseQuimica.solidosSusp }" />
			</fieldset>
			
			<fieldset>
				<input type="hidden" name="_method" value="put" />
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>
	</div>
</body>
</html>