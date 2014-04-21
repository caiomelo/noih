	<div class="title">Técnico Responsável &gt;&gt; Novo</div><hr />
	<c:forEach items="${errors }" var="erro">
		${erro.category } - ${erro.message } <br />
	</c:forEach>

	<form action="<c:url value="/tecnicoResponsavel/novo" />" method="post">
		<fieldset>
			<label for="cadastro_tecnicoResponsavel_nome"
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Nome</label> 
				<input id="cadastro_tecnicoResponsavel_nome" type="text" name="tecnicoResponsavel.nome" value="${tecnicoResponsavel.nome }" 
				<vraptor:hasErrors category="nome">class="errado"</vraptor:hasErrors>/>
				
			<div class="erro">
				<vraptor:hasErrors category="nome">  										  		
					<div>
						<vraptor:showErrors category="nome" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
			
		<fieldset>
			<label for="cadastro_tecnicoResponsavel_formacao"
			<vraptor:hasErrors category="formacao">class="vermelho"</vraptor:hasErrors>>Formação</label> 
			<select id="cadastro_tecnicoResponsavel_formacao" name="tecnicoResponsavel.formacao.id"
				<vraptor:hasErrors category="formacao">class="errado"</vraptor:hasErrors>>
				<c:if test="${tecnicoResponsavel.formacao.id != null and tecnicoResponsavel.formacao.id > 0}">
					<option value="${tecnicoResponsavel.formacao.id }">${tecnicoResponsavel.formacao.nome }</option>
				</c:if>
				<option value="0">Selecione a formação</option>
				<c:forEach items="${formacaoList }" var="formacao">
					<option value="${formacao.id }">${formacao.nome }</option>
				</c:forEach>
			</select>
			<div class="erro">
				<vraptor:hasErrors category="formacao">  										  		
					<div>
						<vraptor:showErrors category="formacao" /> 
					</div>  																	        	
				</vraptor:hasErrors>
			</div>
		</fieldset>
		
		<fieldset>
			<label for="cadastro_tecnicoResponsavel_especialidade1">Especialidade 1 </label>
			<select id="cadastro_tecnicoResponsavel_especialidade1" name="tecnicoResponsavel.especialidade1.id">
				<c:if test="${tecnicoResponsavel.especialidade1.id != null and tecnicoResponsavel.especialidade1.id > 0}">
					<option value="${tecnicoResponsavel.especialidade1.id }">${tecnicoResponsavel.especialidade1.nome }</option>
				</c:if>
				<option value="0">Selecione a especialidade</option>
				<c:forEach items="${especialidadeList }" var="especialidade">
					<option value="${especialidade.id }">${especialidade.nome }</option>
				</c:forEach>
			</select>
		</fieldset>
		
	
		<fieldset>
			<label for="cadastro_tecnicoResponsavel_especialidade2">Especialidade 2</label> 
			<select id="cadastro_tecnicoResponsavel_especialidade2" name="tecnicoResponsavel.especialidade2.id">
				<c:if test="${tecnicoResponsavel.especialidade2.id != null and tecnicoResponsavel.especialidade2.id > 0}">
					<option value="${tecnicoResponsavel.especialidade2.id }">${tecnicoResponsavel.especialidade2.nome }</option>
				</c:if>
				<option value="0">Selecione a especialidade</option>
				<c:forEach items="${especialidadeList }" var="especialidade">
					<option value="${especialidade.id }">${especialidade.nome }</option>
				</c:forEach>
			</select>
		</fieldset>
			
		<fieldset>
			<label for="cadastro_tecnicoResponsavel_telefone">Telefone</label> <input
				type="text" name="tecnicoResponsavel.telefone" value="${tecnicoResponsavel.telefone }" />
		</fieldset>
			
		<fieldset class="full">
			<label for="cadastro_tecnicoResponsavel_email">E-mail</label> <input
				type="text" name="tecnicoResponsavel.email" value="${tecnicoResponsavel.email }" />
		</fieldset>
		
		<fieldset class="full">
			<input type="submit" value="Enviar" />
		</fieldset>

	</form>