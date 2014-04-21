	<div class="title">Problema Geral &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/problemaGeral/novo"/>" method="post">
			<fieldset>
				Digite o tipo de problema
				<label for="cadastro_problemaGeral_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Ocorrência:  </label> 
				<input id="cadastro_problemaGeral_nome" type="text" name="problemaGeral.nome" value="${problemaGeral.nome }" 
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