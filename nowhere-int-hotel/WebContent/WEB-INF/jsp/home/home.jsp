<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema PSF</title>
	<link href="<c:url value="/estilos/home.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="fullWrapper">
		<div class="wrapper" style="text-align: center;padding-top: 10px;">
			<img src="<c:url value="/estilos/images/aquic.png" />" />
		</div>
	</div>
	
	<div id="mid">
		<nav id="opcoes">
			<ul>
				<li class="home ativo"><span><a href="">Home</a></span></li>
				<li class="formularios"><span><a href="<c:url value="/formularios" />">Formulários</a></span></li>
				<li class="relatorios"><span><a href="#">Relatórios</a></span></li>
				<li class="usuarios"><span><a href="#">Usuários</a></span></li>
			</ul>
		</nav>
	</div>

	<div class="wrapper">
		<div id="corpo">
			<p style="color:blue;font-weight: bold;text-align: center">
				GERENCIAMENTO DA SAÚDE NO CULTIVO DE CAMARÕES MARINHOS<br />
			</p>
			<p style="color:blue;font-weight: bold;text-align: center">
				PROCESSO DE OTIMIZAÇÃO: ESTADO DO RIO GRANDE DO NORTE
			</p>
			<br />
			<p style="text-align: center"><strong>Universidade Federal do Rio Grande do Norte</strong></p>
			
			<p><strong>Coordenador: Prof. Dr. Pedro Martins</strong></p>
			<p><strong>Bolsistas CNPq-DTI3:</strong><br />
			Biólogo Marcelo Lima Santos<br />
			Élida Catrina de Sousa</p>
			<p><strong>Bolsistas CNPq-ITIA:</strong><br />
			Marília Sousa<br />
			Michelly Reis de Lima<br />
			Tamiris Henrique</p>
			<p><strong>Curso de Aquicultura UFRN Iniciação Científica Voluntária:</strong><br />
			Anuska Manzo, Emanuelly Peixoto, Gracielly Araújo,<br />
			Magno Hudson, Patrícia Madruga</p>
			<br /><br />
		</div>
	</div>
	
	<div id="footer">
		<p>© Copyright 2013 PSF Aquicultura, Inc. All rights reserved<br />Desenvolvido por e-Dea Jr.</p>
	</div>
</body>
</html>