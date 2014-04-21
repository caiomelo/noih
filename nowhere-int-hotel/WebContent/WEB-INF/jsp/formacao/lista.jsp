	<div class="title">Formação &gt;&gt; Lista</div><hr />
	<c:if test="${not empty mensagemDaLogica  }">
		<div class="msg"> ${mensagemDaLogica } </div>
	</c:if>
	
	<table>
		<tr><th>Formação</th></tr>
		
		<c:forEach items="${formacaoList }" var="formacao">
			<tr>
				<td>${formacao.nome }</td>
				<td><a href="<c:url value="/formacao/edita/${formacao.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/formacao/deleta/${formacao.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
			
		</c:forEach>
	</table>