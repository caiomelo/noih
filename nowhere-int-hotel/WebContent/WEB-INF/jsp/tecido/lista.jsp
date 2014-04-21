	<div class="title">Tecido &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<td>Tecido</td>
		</tr>
		<c:forEach items="${tecidoList }" var="tecido">
			<tr>
			<td>${tecido.orgaoTecido }</td>
			<td><a href="<c:url value="/tecido/edita/${tecido.id }" />">Edita</a></td>
			<td>
				<form action="<c:url value="/tecido/deleta/${tecido.id }" />" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="Deletar" /> 
				</form>
			</td>
			
			</tr>
		</c:forEach>
	</table>