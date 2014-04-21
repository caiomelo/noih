<form action="<c:url value="/amostragem/edita/${amostragem.id }" />" method="post">	
	<fieldset>
		<label for="edita_amostragem_propriedade"
		<vraptor:hasErrors category="propriedade">class="vermelho"</vraptor:hasErrors>>Propriedade</label>
		<select id="edita_amostragem_propriedade" name="amostragem.propriedade.id"
		<vraptor:hasErrors category="propriedade">class="errado"</vraptor:hasErrors>>
			<c:if test="${amostragem.propriedade != null and amostragem.propriedade.id != null and amostragem.propriedade.id > 0 }" >
				<option value="${amostragem.propriedade.id }">${amostragem.propriedade.nome }</option>
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
		<label for="edita_amostragem_data"
			<vraptor:hasErrors category="data">class="vermelho"</vraptor:hasErrors>>Data</label> 
			<input id="edita_amostragem_data" type="text" name="amostragem.data" 
				value="<fmt:formatDate value="${amostragem.data }" pattern="dd/MM/yyyy" />"
			<vraptor:hasErrors category="data">class="errado"</vraptor:hasErrors> />
			
		<div class="erro">
			<vraptor:hasErrors category="data">  										  		
				<div>
					<vraptor:showErrors category="data" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>	

	<fieldset>
		<label for="edita_amostragem_unidade_producao"
		<vraptor:hasErrors category="unidadeProducao">class="vermelho"</vraptor:hasErrors>>Unidade/Producao</label> 
		<input id="edita_amostragem_unidade_producao" type="text" 
			name="amostragem.unidadeProducao" value="${amostragem.unidadeProducao }"
		<vraptor:hasErrors category="unidadeProducao">class="errado"</vraptor:hasErrors> />
		
		<div class="erro">
			<vraptor:hasErrors category="unidadeProducao">  										  		
				<div>
					<vraptor:showErrors category="unidadeProducao" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
		
	<fieldset>
		<label for="edita_amostragem_amostra_lote"
		<vraptor:hasErrors category="amostraLote">class="vermelho"</vraptor:hasErrors>>Amostra/Lote</label> 
		<input id="edita_amostragem_amostra_lote"
			type="text" name="amostragem.amostraLote" value="${amostragem.amostraLote }"
		<vraptor:hasErrors category="amostraLote">class="errado"</vraptor:hasErrors> />
		<div class="erro">
			<vraptor:hasErrors category="amostraLote">  										  		
				<div>
					<vraptor:showErrors category="amostraLote" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	
	<fieldset>
		<label for="edita_amostragem_tecnica"
		<vraptor:hasErrors category="tecnica">class="vermelho"</vraptor:hasErrors>>Técnica</label> 
		<input id="edita_amostragem_tecnica"
			type="text" name="amostragem.tecnica" value="${amostragem.tecnica }" 
		<vraptor:hasErrors category="tecnica">class="errado"</vraptor:hasErrors>/>
		<div class="erro">
			<vraptor:hasErrors category="tecnica">  										  		
				<div>
					<vraptor:showErrors category="tecnica" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	
	<fieldset>
		<label for="edita_amostragem_observacao">Observação</label>
		<textarea id="edita_amostragem_observacao" rows="10" cols="30" name="amostragem.observacao">${amostragem.observacao }</textarea> 
	</fieldset>
	
	<fieldset>
		<input type="hidden" name="_method" value="put" />
		<input type="submit" value="Enviar" />
	</fieldset>

</form>