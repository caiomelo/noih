	<div class="title">Setor &gt;&gt; Lista</div><hr />
	<c:if test="${not empty mensagemDaLogica  }">
		<div class="msg"> ${mensagemDaLogica } </div>
	</c:if>
	<h3>Setor</h3>
	<table border="1">
		<tr><th>Setor</th></tr>
		<c:forEach items="${setorList }" var="setor">
			<tr>
				<td>${setor.setorBacia }</td>
				<td><a href="<c:url value="/setor/edita/${setor.id }" />">Edita</a></td>
				<td>
					<form action="<c:url value="/setor/deleta/${setor.id }"/>" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Deletar" />
					</form>	
				</td>
			</tr>
			
		</c:forEach>
	</table>