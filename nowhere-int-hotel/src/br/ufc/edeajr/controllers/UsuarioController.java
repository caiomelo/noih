package br.ufc.edeajr.controllers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.UsuarioDAO;
import br.ufc.edeajr.model.Usuario;

@Resource
public class UsuarioController {

	private final UsuarioDAO usuarioDAO;
	private final Result result;
	private final Validator validator;
	
	public UsuarioController(UsuarioDAO usuarioDAO, Result result, Validator validator) {
		this.usuarioDAO = usuarioDAO;
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("usuario")
	public void index() {
		result.include("ativo", "usuarios");
	}
	
	@Get @Path("usuario/novo")
	public void formulario() { }
	
	@Post @Path("usuario/novo")
	public void adiciona(Usuario usuario, String repitaSenha) {
		valida(usuario, repitaSenha);
		validator.onErrorUsePageOf(this).formulario();
		try {
			usuarioDAO.save(usuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}

	@Get @Path("usuario/lista")
	public List<Usuario> lista() {
		List<Usuario> usuarioList = null;
		try {
			usuarioList = usuarioDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioList;
	}
	
	private void valida(Usuario usuario, String repitaSenha) {
		
		if(validaEmail(usuario.getEmail())) {
			validator.add(new ValidationMessage("Email inválido. Digite um email válido", "email"));
		}
		
		if(usuario.getEmail() != null && usuarioDAO.existeEmail(usuario.getEmail())) {
			validator.add(new ValidationMessage("Email já cadastrado. Digite outro email", "email"));
		}
		
		if(usuario.getLogin() != null && usuarioDAO.existeLogin(usuario.getLogin())) {
			validator.add(new ValidationMessage("Login já cadastrado. Digite outro login", "login"));
		}
		
		if(usuario.getTelefone1() != null && !usuario.getTelefone1().isEmpty() && !validaTelefone(usuario.getTelefone1())) {
			validator.add(new ValidationMessage("Formato de telefone inválido", "telefone1"));
		}
		
		if(usuario.getTelefone2() != null && !usuario.getTelefone2().isEmpty() && !validaTelefone(usuario.getTelefone2())) {
			validator.add(new ValidationMessage("Formato de telefone inválido", "telefone2"));
			
		}
		
		if(repitaSenha == null) {
			validator.add(new ValidationMessage("Campo obrigatório", "repitaSenha"));
		} else {
			if(usuario.getSenha() != null && !usuario.getSenha().equals(repitaSenha)) {
				validator.add(new ValidationMessage("As senhas não conferem", "repitaSenha"));
			}
		}
		
		validator.validate(usuario);
	}
	
	private boolean validaTelefone(String telefone) {
		String formato = "\\([0-9]{2}\\)(9)?[0-9]{4}-[0-9]{4}";
		Pattern pattern = Pattern.compile(formato);
		Matcher matcher = pattern.matcher(telefone);
		return matcher.find();
	}
	
	private boolean validaEmail(String email) {
		return email != null && !(email.contains("@") 
				&& email.contains(".") 
				&& email.lastIndexOf(".") > email.indexOf("@"));
	}
	
	@Post @Path("login")
	public void login(String login, String senha) { 
		Usuario usuario = usuarioDAO.login(login, senha);
		if(usuario != null) {
			result.redirectTo(HomeController.class).home();
		} 
		result.redirectTo(HomeController.class).home();
	}
}
