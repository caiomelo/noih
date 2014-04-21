	<div class="title">Tecido &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/tecido/novo"/>" method="post">
			<fieldset>
				<label for="cadastro_tecido_orgaoTecido" 
				<vraptor:hasErrors category="orgaoTecido">class="vermelho"</vraptor:hasErrors>>Tecido</label> 
				<input id="cadastro_tecido_orgaoTecido" type="text" name="tecido.orgaoTecido" value="${tecido.orgaoTecido }" 
					<vraptor:hasErrors category="orgaoTecido">class="errado"</vraptor:hasErrors>/>
			
				<div class="erro">
					<vraptor:hasErrors category="orgaoTecido">  										  		
						<div>
							<vraptor:showErrors category="orgaoTecido" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset class="full">
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>