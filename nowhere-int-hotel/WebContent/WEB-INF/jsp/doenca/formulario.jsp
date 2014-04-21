	<div class="title">Doença &gt;&gt; Novo</div><hr />
	<form action="<c:url value="/doenca/novo" />" method="post">
		<fieldset>
			<label for="cadastro_doenca_nome"
			<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Doença</label> 
				<input type="text" name="doenca.nome" value="${doenca.nome }" 
			<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>/>
			
			<div class="erro">
				<vraptor:hasErrors category="nome">  										  		
					<div><vraptor:showErrors category="nome" /></div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
		
		<fieldset>
			<label for="cadastro_doenca_especialista">Especialista</label> 
			<input id="cadastro_doenca_especialista" type="text" name="doenca.especialista" class="blabla"
				value="${doenca.especialista }" />
		</fieldset>

		<fieldset class="full">
			<label for="cadastro_doenca_observacao">Observação</label>
				<textarea rows="3" name="doenca.observacao">${doenca.observacao }</textarea>
		</fieldset>
		
		<fieldset class="full">
			<input type="submit" value="Enviar" />
		</fieldset>
	</form>