	<div class="title">Problema Geral &gt;&gt; Lista</div><hr />
	<c:if test="${not empty mensagemDaLogica  }">
		<div class="msg"> ${mensagemDaLogica } </div>
	</c:if>
	
	<table>
		<tr><th>Ocorrências</th></tr>
		
		<c:forEach items="${problemaGeralList }" var="problemaGeral">
			<tr>
				<td>${problemaGeral.nome }</td>
				<td><a href="<c:url value="/problemaGeral/edita/${problemaGeral.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/problemaGeral/deleta/${problemaGeral.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
			
		</c:forEach>
		
	
	</table>
	
	
	
</body>
</html>