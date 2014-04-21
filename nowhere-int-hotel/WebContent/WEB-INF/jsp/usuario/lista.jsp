
<table border="1">
	<tr>
		<th>Nome</th>
		<th>Email</th>
		<th>Telefone 1</th>
	</tr>
<c:forEach items="${usuarioList }" var="usuario">
	<tr>
		<td>${usuario.nome }</td>
		<td>${usuario.email }</td>
		<td>${usuario.telefone1 }</td>
	</tr>	
</c:forEach>
</table>
