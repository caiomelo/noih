	<div class="title">Técnico Responsável &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Formação</th>
			<th>Especialidade 1</th>
			<th>Especialidade 2</th>
			<th>Telefone</th>
			<th>Email</th>	
		</tr>
		
		<c:forEach items="${tecnicoResponsavelList }" var="tecnicoResponsavel">
			<tr>
				<td>${tecnicoResponsavel.nome }</td>
				<td>${tecnicoResponsavel.formacao.nome }</td>
				<td>${tecnicoResponsavel.especialidade1.nome }</td>
				<td>${tecnicoResponsavel.especialidade2.nome }</td>
				<td>${tecnicoResponsavel.telefone }</td>
				<td>${tecnicoResponsavel.email }</td>
				<td><a href="<c:url value="/tecnicoResponsavel/edita/${tecnicoResponsavel.id }" />">Edita</a></td>
			</tr>
			
		</c:forEach>
	</table>