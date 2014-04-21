		<div class="title">Especialidade &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/especialidade/novo"/>" method="post">
			<fieldset class="center">
				<label for="cadastro_especialidade_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Especialidade</label> 
				<input id="cadastro_especialidade_nome" type="text" name="especialidade.nome" value="${especialidade.nome }" 
					<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>/>
			
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