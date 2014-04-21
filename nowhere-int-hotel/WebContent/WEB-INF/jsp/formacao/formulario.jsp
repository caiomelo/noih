		<div class="title">Formação &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/formacao/novo"/>" method="post">
			<fieldset class="full">
				<label for="cadastro_formacao_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Formação</label> 
				<textarea rows="3" id="cadastro_formacao_nome" name="formacao.nome"
					<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>
				>${formacao.nome}</textarea> 
			
				<div class="erro">
					<vraptor:hasErrors category="nome">  										  		
						<div>
							<vraptor:showErrors category="nome" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset class="full">
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>