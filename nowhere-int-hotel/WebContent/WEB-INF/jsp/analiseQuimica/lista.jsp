	<div class="title">Análise Química &gt;&gt; Lista</div><hr />
	<table border="1" >
		<tr>
			<th>Propriedade</th>
			<th>Data</th>
		</tr>
		<c:forEach items="${analiseQuimicaList }" var="analiseQuimica">
			<tr>
				<td>${analiseQuimica.propriedade.nome }</td>
				<td><fmt:formatDate value="${analiseQuimica.data }" pattern="dd/MM/yyyy" /></td>
				<td><a href="<c:url value="/analiseQuimica/edita/${analiseQuimica.id }"/>">Edita</a></td>
			</tr>
		</c:forEach>
	</table>