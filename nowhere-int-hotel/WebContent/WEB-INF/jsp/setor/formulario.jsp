	<div class="title">Setor &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/setor/novo" />" method="post">
			<fieldset>
				<label for="cadastro_setor_setorBacia" 
				<vraptor:hasErrors category="setorBacia">class="vermelho"</vraptor:hasErrors>>Setor</label> 
				<input id="cadastro_setor_setorBacia" type="text" name="setor.setorBacia" value="${setor.setorBacia }" 
					<vraptor:hasErrors category="setorBacia">class="errado"</vraptor:hasErrors>/>
			
				<div class="erro">
					<vraptor:hasErrors category="setorBacia">  										  		
						<div>
							<vraptor:showErrors category="setorBacia" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset class="full">
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>