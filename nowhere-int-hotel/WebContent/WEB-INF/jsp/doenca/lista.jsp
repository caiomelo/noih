	<div class="title">Doença &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Especialista</td>
			<td>Observação</td>
			
			<c:forEach items="${doencaList }" var="doenca">
				<tr>
					<td>${doenca.nome }</td>
					<td>${doenca.especialista }</td>
					<td>${doenca.observacao }</td>
					<td><a href="<c:url value="/doenca/edita/${doenca.id }" />">Edita</a></td>
					<td>
						<form action="<c:url value="/doenca/deleta/${doenca.id }" />" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<input type="submit" value="deletar"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>