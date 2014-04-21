	<div class="title">Problema &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/problema/novo"/>" method="post">
			<fieldset>
				<label for="cadastro_problema_ocorrencia" 
				<vraptor:hasErrors category="ocorrencia">class="vermelho"</vraptor:hasErrors>>Problema</label> 
				<input id="cadastro_problema_ocorrencia" type="text" name="problema.ocorrencia" value="${problema.ocorrencia }" 
				<vraptor:hasErrors category="ocorrencia">class="errado"</vraptor:hasErrors>/>
			
				<div class="erro">
					<vraptor:hasErrors category="ocorrencia">  										  		
						<div>
							<vraptor:showErrors category="ocorrencia" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset class="full">
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>