
<form action="<c:url value="/usuario/novo"/>" method="post">
	<fieldset class="center">
		<label for="cadastro_usuario_nome"
		<vraptor:hasErrors category="nome">class="vermelho"</vraptor:hasErrors>>Nome Completo:</label> 
		<input type="text" name="usuario.nome" value="${usuario.nome }"
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
		<label for="cadastro_usuario_email"
		<vraptor:hasErrors category="email">class="vermelho"</vraptor:hasErrors>>E-mail:</label> 
		<input type="text" name="usuario.email" value="${usuario.email }"
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
		<label for="cadastro_usuario_telefone1"
		<vraptor:hasErrors category="telefone1">class="vermelho"</vraptor:hasErrors>>Telefone1: (xx)xxxx-xxxx</label> 
		<input type="text" name="usuario.telefone1" value="${usuario.telefone1 }"
		<vraptor:hasErrors category="telefone1">class="errado"</vraptor:hasErrors>/>
		<div class="erro">
			<vraptor:hasErrors category="telefone1">  										  		
				<div>
					<vraptor:showErrors category="telefone1" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	<fieldset>
		<label for="cadastro_usuario_telefone2"
		<vraptor:hasErrors category="telefone2">class="vermelho"</vraptor:hasErrors>>Telefone2: (xx)xxxx-xxxx</label> 
		<input type="text" name="usuario.telefone2" value="${usuario.telefone2 }"
		<vraptor:hasErrors category="telefone2">class="errado"</vraptor:hasErrors>/>
		<div class="erro">
			<vraptor:hasErrors category="telefone2">  										  		
				<div>
					<vraptor:showErrors category="telefone2" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	<fieldset>
		<label for="cadastro_usuario_login"
		<vraptor:hasErrors category="login">class="vermelho"</vraptor:hasErrors>>Login:</label> 
		<input type="text" name="usuario.login" value="${usuario.login }"
		<vraptor:hasErrors category="login">class="errado"</vraptor:hasErrors>/>
		<div class="erro">
			<vraptor:hasErrors category="login">  										  		
				<div>
					<vraptor:showErrors category="login" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	<fieldset>
		<label for="cadastro_usuario_senha"
		<vraptor:hasErrors category="senha">class="vermelho"</vraptor:hasErrors>>Senha:</label> 
		<input type="password" name="usuario.senha" value="${usuario.senha }"
		<vraptor:hasErrors category="senha">class="errado"</vraptor:hasErrors>/>
		<div class="erro">
			<vraptor:hasErrors category="senha">  										  		
				<div>
					<vraptor:showErrors category="senha" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	<fieldset>
		<label for="cadastro_usuario_repitaSenha"
		<vraptor:hasErrors category="repitaSenha">class="vermelho"</vraptor:hasErrors>>Repita sua senha:</label> 
		<input type="password" name="repitaSenha" value="${repitaSenha }"
		<vraptor:hasErrors category="repitaSenha">class="errado"</vraptor:hasErrors>/>
		<div class="erro">
			<vraptor:hasErrors category="repitaSenha">  										  		
				<div>
					<vraptor:showErrors category="repitaSenha" /> 
				</div>  																	        	
			</vraptor:hasErrors>
		</div>
	</fieldset>
	
	<fieldset class="full">
		<input type="submit" value="Enviar" />
	</fieldset>
</form>
