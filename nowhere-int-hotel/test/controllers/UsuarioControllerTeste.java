package br.ufc.edeajr.controllers.teste;

import br.ufc.edeajr.controllers.UsuarioController;
import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.UsuarioDAO;
import br.ufc.edeajr.model.Usuario;

public class UsuarioControllerTeste {

	private UsuarioController usuarioController;
	private UsuarioDAO usuarioDAO;
	private Validator validator;
	private Result result;

	@Before
	public void setUp() {
		usuarioDAO = Mockito.mock(UsuarioDAO.class);
		validator = Mockito.spy(new MockValidator());
		result = Mockito.spy(new MockResult());
		usuarioController = new UsuarioController(usuarioDAO, result, validator);
	}

	@Test
	public void adicionaUsuarioConsistenteTeste() throws DaoException {
		Usuario usuario = getUsuarioConsistente();
		usuarioController.adiciona(usuario, usuario.getSenha());
		Mockito.verify(usuarioDAO).save(usuario);

	}

	@Test(expected = ValidationException.class)
	public void adicionaUsuarioInconsistenteTest() {
		Usuario usuario = getUsuarioInconsistente();
		usuarioController.adiciona(usuario, usuario.getSenha());

		Mockito.verify(usuarioDAO).existeEmail(usuario.getEmail());
		Mockito.verify(usuarioDAO).existeLogin(usuario.getLogin());

		
		// result.included().containsKey("errors"));
		Mockito.verifyNoMoreInteractions(usuarioDAO);
	}

	@Test
	public void redirecionaTeste() {
		Usuario usuario = getUsuarioConsistente();

		UsuarioController usuarioControllerSpy = Mockito.spy(usuarioController);

		Mockito.when(result.redirectTo(usuarioController)).thenReturn(
				usuarioControllerSpy);

		usuarioController.adiciona(usuario, usuario.getSenha());

		Mockito.verify(usuarioControllerSpy).lista();
	}

	private Usuario getUsuarioConsistente() {
		Usuario usuario = new Usuario();
		usuario.setNome("Francisco de Castro");
		usuario.setEmail("franciscoescastro@gmail.com");
		usuario.setLogin("fcastro");
		usuario.setSenha("123456");
		usuario.setTelefone1("(85)8888-7777");
		return usuario;
	}

	private Usuario getUsuarioInconsistente() {
		Usuario usuario = new Usuario();
		usuario.setNome("Francisco");
		usuario.setEmail("franciscoescastrogmail.com");
		usuario.setLogin("fcastro");
		usuario.setSenha("123456");
		usuario.setTelefone1("(85)8888-7777");
		usuario.setTelefone2("(85)8888-7777");
		return usuario;
	}

}