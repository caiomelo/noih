	<div class="title">Patógeno &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/patogeno/novo"/>" method="post">
			<fieldset>
				<label for="cadastro_patogeno_nome" 
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Patógeno</label> 
				<input id="cadastro_patogeno_nome" type="text" name="patogeno.nome" value="${patogeno.nome }" 
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