	<div class="title">Especialidade &gt;&gt; Lista</div><hr />
	<c:if test="${not empty mensagemDaLogica  }">
		<div class="msg"> ${mensagemDaLogica } </div>
	</c:if>
	
	<table>
		<tr><th>Especialidade</th></tr>
		
		<c:forEach items="${especialidadeList }" var="especialidade">
			<tr>
				<td>${especialidade.nome }</td>
				<td><a href="<c:url value="/especialidade/edita/${especialidade.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/especialidade/deleta/${especialidade.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
			
		</c:forEach>
	</table>