	<div class="title">Município &gt;&gt; Novo</div><hr />
	<form action="<c:url value="/municipio/novo" />" method="post">
		<fieldset>
			<label for="cadastro_municipio_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Nome</label> 
				<input id="cadastro_municipio_nome" type="text" name="municipio.nome" value="${municipio.nome }" 
				<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>/>
		
			<div class="erro">
				<vraptor:hasErrors category="nome">  										  		
					<div>
						<vraptor:showErrors category="nome" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
		
		<fieldset>
			<label for="cadastro_municipio_uf"
			<vraptor:hasErrors category="uf">class="vermelho"</vraptor:hasErrors>>UF</label> 
			<select id="cadastro_municipio_uf" name="municipio.uf.id"
				<vraptor:hasErrors category="uf">class="errado"</vraptor:hasErrors>>
				<c:if test="${municipio.uf.id != null and municipio.uf.id > 0}">
					<option value="${municipio.uf.id }">${municipio.uf.nome } - ${municipio.uf.sigla }</option>
				</c:if>
				<option value="0">Selecione a UF</option>
				<c:forEach items="${ufList }" var="uf">
					<option value="${uf.id }">${uf.nome } - ${uf.sigla }</option>
				</c:forEach>
			</select>
			
			<div class="erro">
				<vraptor:hasErrors category="uf">  										  		
					<div>
						<vraptor:showErrors category="uf" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
		
		<fieldset class="full">
			<input type="submit" value="Enviar" />
		</fieldset>
		
	</form>