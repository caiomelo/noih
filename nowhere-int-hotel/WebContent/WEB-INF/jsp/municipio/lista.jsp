<div class="title">Município &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<th>Municipio</th>
			<th>UF</th>
		</tr>	
		
		<c:forEach items="${municipioList }" var="municipio">
			<tr>
				<td>${municipio.nome }</td>
				<td>${municipio.uf.sigla }</td>
				<td><a href="<c:url value="/municipio/edita/${municipio.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/municipio/deleta/${municipio.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
		</c:forEach>
		<tr></tr>
	</table>