	<div class="title">Problema &gt;&gt; Lista</div><hr />
	<c:if test="${not empty mensagemDaLogica  }">
		<div class="msg"> ${mensagemDaLogica } </div>
	</c:if>
	
	<table>
		<tr><th>Problema</th></tr>
		
		<c:forEach items="${problemaList }" var="problema">
			<tr>
				<td>${problema.ocorrencia }</td>
				<td><a href="<c:url value="/problema/edita/${problema.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/problema/deleta/${problema.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>