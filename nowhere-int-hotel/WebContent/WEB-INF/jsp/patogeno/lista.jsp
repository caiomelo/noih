	<div class="title">Pat�geno &gt;&gt; Lista</div><hr />
	<c:if test="${not empty mensagemDaLogica  }">
		<div class="msg"> ${mensagemDaLogica } </div>
	</c:if>
	
	<table>
		<tr><th>Pat�geno</th></tr>
		
		<c:forEach items="${patogenoList }" var="patogeno">
			<tr>
				<td>${patogeno.nome }</td>
				<td><a href="<c:url value="/patogeno/edita/${patogeno.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/patogeno/deleta/${patogeno.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>