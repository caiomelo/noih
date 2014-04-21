	<div class="title">Propriedade &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Tipo</th>
			<th>Proprietário</th>
		</tr>
		
		<c:forEach items="${propriedadeList }" var="propriedade">
			<tr>
				<td>${propriedade.id }</td>
				<td>${propriedade.nome }</td>
				<td>${propriedade.tipo }</td>
				<td>${propriedade.proprietario }</td>
				<td><a href="<c:url value="/propriedade/edita/${propriedade.id }" />">Editar</a></td>
			</tr>
		</c:forEach>
	</table>