	<div class="title">Propriedade &gt;&gt; Novo</div><hr />
		<form action="<c:url value="/propriedade/novo" />" method="post">
			<fieldset>
				<label for="cadastro_propriedade_nome"
				<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Nome</label> 
				<input type="text" name="propriedade.nome" value="${propriedade.nome }" 
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
				<label for="cadastro_propriedade_tipo"
				<vraptor:hasErrors category="tipo">class="vermelho"</vraptor:hasErrors>>Tipo</label> 
				<select id="cadastro_propriedade_tipo" name="propriedade.tipo"
					<vraptor:hasErrors category="tipo">class="errado"</vraptor:hasErrors>>
					<c:if test="${propriedade.tipo != null }">
						<option value="${propriedade.tipo }">${propriedade.tipo }</option>
					</c:if>
					<option value="0">Selecione o tipo</option>
					<option value="LAB">LAB</option>
					<option value="FAZ">FAZ</option>
					<option value="BNF">BNF</option>
					<option value="OUT">OUT</option>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="tipo">  										  		
						<div>
							<vraptor:showErrors category="tipo" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<label for="cadastro_propriedade_alugada">Alugada</label> 
				<select id="cadastro_propriedade_alugada" name="propriedade.alugada">
					<c:choose>
						<c:when test="${propriedade.alugada == true}">
							<option value="true">SIM</option>
							<option value="false">N�O</option>
						</c:when>
						
						<c:otherwise>
							<option value="false">N�O</option>
							<option value="true">SIM</option>
						</c:otherwise>
					</c:choose>
				</select>
				<div class="erro">
					<vraptor:hasErrors category="alugada">  										  		
						<div>
							<vraptor:showErrors category="alugada" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<label for="cadastro_propriedade_proprietario"
					<vraptor:hasErrors category="proprietario">class="vermelho"</vraptor:hasErrors>>Proprietario</label> 
					<input type="text" name="propriedade.proprietario" value="${propriedade.proprietario }" 
					<vraptor:hasErrors category="proprietario">class="errado"</vraptor:hasErrors>/>
					
				<div class="erro">
					<vraptor:hasErrors category="proprietario">  										  		
						<div>
							<vraptor:showErrors category="proprietario" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<label for="cadastro_propriedade_representanteLegal"
					<vraptor:hasErrors category="representanteLegal">class="vermelho"</vraptor:hasErrors>>RepresentanteLegal</label> 
					<input type="text" name="propriedade.representanteLegal" value="${propriedade.representanteLegal }" 
					<vraptor:hasErrors category="representanteLegal">class="errado"</vraptor:hasErrors>/>
				<div class="erro">
					<vraptor:hasErrors category="representanteLegal">  										  		
						<div>
							<vraptor:showErrors category="representanteLegal" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
			
				<label id="cadastro_propriedade_tecnicoResponsavel"
					<vraptor:hasErrors category="tecnicoResponsavel">class="vermelho"</vraptor:hasErrors>>T�cnico Respons�vel</label>
					<select id="cadastro_propriedade_tecnicoResponsavel" name="propriedade.tecnicoResponsavel.id"
					<vraptor:hasErrors category="tecnicoResponsavel">class="errado"</vraptor:hasErrors>>
					<c:if test="${propriedade.tecnicoResponsavel != null and propriedade.tecnicoResponsavel.id != null 
						and propriedade.tecnicoResponsavel.id > 0}">
						<option value="${propriedade.tecnicoResponsavel.id }">${propriedade.tecnicoResponsavel.id } 
							- ${propriedade.tecnicoResponsavel.nome }</option>
					</c:if>
					<option value="0">Selecione a propriedade</option>
					<c:forEach items="${tecnicoResponsavelList }" var="tecnicoResponsavel">
						<option value="${tecnicoResponsavel.id }">${tecnicoResponsavel.id } - ${tecnicoResponsavel.nome }</option>
					</c:forEach>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="tecnicoResponsavel">  										  		
						<div>
							<vraptor:showErrors category="tecnicoResponsavel" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<label for="cadastro_propriedade_endereco"
					<vraptor:hasErrors category="endereco">class="vermelho"</vraptor:hasErrors>>Endere�o</label> 
					<input id="cadastro_propriedade_endereco" type="text" name="propriedade.endereco" value="${propriedade.endereco }" 
					<vraptor:hasErrors category="endereco">class="errado"</vraptor:hasErrors>/>
				<div class="erro">
					<vraptor:hasErrors category="endereco">  										  		
						<div>
							<vraptor:showErrors category="endereco" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_propriedade_municipio"
					<vraptor:hasErrors category="municipio">class="vermelho"</vraptor:hasErrors>>Municipio</label> 
					<select id="cadastro_propriedade_municipio" name="propriedade.municipio.id"
						<vraptor:hasErrors category="municipio">class="errado"</vraptor:hasErrors>>
						<c:if test="${propriedade.municipio != null and propriedade.municipio.uf != null 
							and propriedade.municipio.uf.id != null and propriedade.municipio.uf.id > 0}">
							<option value="${propriedade.municipio.id }">${propriedade.municipio.nome } - ${propriedade.municipio.uf.sigla }</option>
						</c:if>
						<option value="0">Selecione o municipio</option>
						<c:forEach items="${municipioList }" var="municipio">
							<option value="${municipio.id }">${municipio.nome } - ${municipio.uf.sigla }</option>
						</c:forEach>
					</select>
				
				<div class="erro">
					<vraptor:hasErrors category="municipio">  										  		
						<div>
							<vraptor:showErrors category="municipio" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
			<fieldset>
				<label for="cadastro_propriedade_telefone"
					<vraptor:hasErrors category="telefone">class="vermelho"</vraptor:hasErrors>>Telefone</label> 
					<input type="text" name="propriedade.telefone" value="${propriedade.telefone }" 
					<vraptor:hasErrors category="telefone">class="errado"</vraptor:hasErrors>/>
				
				<div class="erro">
					<vraptor:hasErrors category="telefone">  										  		
						<div>
							<vraptor:showErrors category="telefone" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_propriedade_celular"
					<vraptor:hasErrors category="celular">class="vermelho"</vraptor:hasErrors>>Celular</label> 
					<input type="text" name="propriedade.celular" value="${propriedade.celular }" 
					<vraptor:hasErrors category="celular">class="errado"</vraptor:hasErrors>/>
				<div class="erro">
					<vraptor:hasErrors category="celular">  										  		
						<div>
							<vraptor:showErrors category="celular" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_propriedade_email"
					<vraptor:hasErrors category="email">class="vermelho"</vraptor:hasErrors>>Email</label> 
					<input type="text" name="propriedade.email" value="${propriedade.email }" 
					<vraptor:hasErrors category="email">class="errado"</vraptor:hasErrors>/>
				<div class="erro">
					<vraptor:hasErrors category="email">  										  		
						<div>
							<vraptor:showErrors category="email" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_propriedade_setor"
					<vraptor:hasErrors category="setor">class="vermelho"</vraptor:hasErrors>>Setor</label>
				 
				<select id="cadastro_propriedade_setor" name="propriedade.setor.id"
					<vraptor:hasErrors category="setor">class="errado"</vraptor:hasErrors>>
					<c:if test="${propriedade.setor != null	and propriedade.setor.id != null and propriedade.setor.id > 0}">
						<option value="${propriedade.setor.id }">${propriedade.setor.id } 
							- ${propriedade.setor.setorBacia }</option>
					</c:if>
					<option value="0">Selecione o setor</option>
					<c:forEach items="${setorList }" var="setor">
						<option value="${setor.id }">${setor.id } - ${setor.setorBacia }</option>
					</c:forEach>
				</select>
				
				<div class="erro">
					<vraptor:hasErrors category="setor">  										  		
						<div>
							<vraptor:showErrors category="setor" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			
	
			<fieldset>
				<label for="cadastro_propriedade_qVes"
					<vraptor:hasErrors category="qVes">class="vermelho"</vraptor:hasErrors>>q.VEs</label> 
					<input type="text" name="propriedade.qVes" value="${propriedade.qVes }" 
					<vraptor:hasErrors category="qVes">class="errado"</vraptor:hasErrors> />
				<div class="erro">
					<vraptor:hasErrors category="qVes">  										  		
						<div>
							<vraptor:showErrors category="qVes" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
	
			<fieldset>
				<label for="cadastro_propriedade_inicioOpe"
					<vraptor:hasErrors category="inicioOpe">class="vermelho"</vraptor:hasErrors>>In�cio da Opera��o</label> 
					<input type="text" name="propriedade.inicioOpe" value='<fmt:formatDate value="${propriedade.inicioOpe }" 
						pattern="dd/MM/yyyy" />' 
					<vraptor:hasErrors category="inicioOpe">class="errado"</vraptor:hasErrors>/>
				<div class="erro">
					<vraptor:hasErrors category="inicioOpe">  										  		
						<div>
							<vraptor:showErrors category="inicioOpe" /> 
						</div>  																	        	
					</vraptor:hasErrors>
				</div>
			</fieldset>
			<fieldset class="full">
				<input type="submit" value="Enviar" />
			</fieldset>
			
		</form>