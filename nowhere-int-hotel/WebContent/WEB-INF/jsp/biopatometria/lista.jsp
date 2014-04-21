	<div class="title">Biopatometria &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<th>Propriedade</th>
			<th>Problema</th>
			<th>Data</th>
		</tr>
		<c:forEach items="${biopatometriaList }" var="biopatometria">
			<tr>
				<td>${biopatometria.propriedade.nome }</td>
				<td>${biopatometria.problema.ocorrencia }</td>
				<td><fmt:formatDate value="${biopatometria.data }" pattern="dd/MM/yyyy" /></td>
				<td><a href="<c:url value="/biopatometria/edita/${biopatometria.id }" />">Edita</a></td>
			</tr>
		</c:forEach>
	
	</table>