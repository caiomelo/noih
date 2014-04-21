	<div class="title">Amostragem &gt;&gt; Lista</div><hr />
	<table border="1">
		<tr>
			<th>Propriedade</th>
			<th>Data</th>
			<th>Unidade/Produ��o</th>
			<th>Amostra/Lote</th>
			<th>T�cnica</th>
			<th>Observa��o</th>
		</tr>
		<c:forEach items="${amostragemList }" var="amostragem">
			<tr>
				<th>${amostragem.propriedade.nome }</th>
				<th><fmt:formatDate value="${amostragem.data }" pattern="dd/MM/yyyy" /></th>
				<th>${amostragem.unidadeProducao }</th>
				<th>${amostragem.amostraLote }</th>
				<th>${amostragem.tecnica }</th>
				<th>${amostragem.observacao }</th>
				<th><a href="<c:url value="/amostragem/edita/${amostragem.id }" />">Edita</a></th>
			</tr>
		</c:forEach>
	</table>