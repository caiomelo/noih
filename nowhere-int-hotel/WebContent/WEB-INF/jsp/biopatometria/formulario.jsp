		<div class="title">Biopatometria &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/biopatometria/novo"/>" method="post">
			<fieldset>
				<label for="cadastro_biopatometria_propriedade"
				<vraptor:hasErrors category="propriedade">class="vermelho"</vraptor:hasErrors>>Propriedade</label>
				<select id="cadastro_biopatometria_propriedade" name="biopatometria.propriedade.id"
				<vraptor:hasErrors category="propriedade">class="errado"</vraptor:hasErrors>>
					<c:if test="${biopatometria.propriedade != null and biopatometria.propriedade.id != null and biopatometria.propriedade.id > 0 }" >
						<option value="${biopatometria.propriedade.id }">${biopatometria.propriedade.nome }</option>
					</c:if>
					<option value="0">Selecione a propriedade</option>
					<c:forEach items="${propriedadeList }" var="propriedade">
						<option value="${propriedade.id }">${propriedade.nome }</option>
					</c:forEach>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="propriedade">  										  		
						<div>
							<vraptor:showErrors category="propriedade" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_biopatometria_problema"
				<vraptor:hasErrors category="problema">class="vermelho"</vraptor:hasErrors>>Problema Diagnosticado</label>
				<select id="cadastro_biopatometria_problema" name="biopatometria.problema.id"
				<vraptor:hasErrors category="problema">class="errado"</vraptor:hasErrors>>
					<c:if test="${biopatometria.problema != null and biopatometria.problema.id != null and biopatometria.problema.id > 0 }" >
						<option value="${biopatometria.problema.id }">${biopatometria.problema.ocorrencia }</option>
					</c:if>
					<option value="0">Selecione o problema</option>
					<c:forEach items="${problemaList }" var="problema">
						<option value="${problema.id }">${problema.ocorrencia }</option>
					</c:forEach>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="problema">  										  		
						<div>
							<vraptor:showErrors category="problema" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
	
			<fieldset>
				<label for="cadastro_biopatometria_data"
				<vraptor:hasErrors category="data">class="vermelho"</vraptor:hasErrors>>Data</label> 
				<input id="cadastro_biopatometria_data" class="blabla" type="text" name="biopatometria.data"
					value='<fmt:formatDate value="${biopatometria.data }" pattern="dd/MM/yyyy" />' 
				<vraptor:hasErrors category="data">class="errado"</vraptor:hasErrors>/>
				
				<div class="erro">
					<vraptor:hasErrors category="data">  										  		
						<div>
							<vraptor:showErrors category="data" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_biopatometria_up">UP</label> 
				<input id="cadastro_biopatometria_up" type="text" name="biopatometria.up" value="${biopatometria.up }" />
			</fieldset>
	
			<fieldset>
				<label for="cadastro_biopatometria_qtdAmostra">Quantidade da Amostra </label> 
				<input id="cadastro_biopatometria_qtdAmostra"type="text" name="biopatometria.qtdAmostra" value="${biopatometria.qtdAmostra }" />
			</fieldset>
	
			<fieldset>
				<label for="cadastro_biopatometria_qtdAfetado">Quantidade Afetada </label> 
				<input id="cadastro_biopatometria_qtdAfetado"type="text" name="biopatometria.qtdAfetado" value="${biopatometria.qtdAfetado }" />
			</fieldset>
	
			<fieldset class="center">
				<label for="cadastro_biopatometria_grauSeveriadade"
				<vraptor:hasErrors category="grauSeveridade">class="vermelho"</vraptor:hasErrors>>Grau de Severidade</label> 
				<select id="cadastro_biopatometria_grauSeveridade" name="biopatometria.grauSeveridade"
				<vraptor:hasErrors category="grauSeveridade">class="errado"</vraptor:hasErrors>>
					<c:if test="${biopatometria.grauSeveridade != null and biopatometria.grauSeveridade != 0}">
						<option value="${biopatometria.grauSeveridade }">${biopatometria.grauSeveridade }</option>
					</c:if>
					<option value="0">Selecione o grau de severidade</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="grauSeveridade">  										  		
						<div>
							<vraptor:showErrors category="grauSeveridade" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset class="full">
				<input type="submit" value="Enviar" />
			</fieldset>
		</form>