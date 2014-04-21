package br.ufc.edeajr.controllers.teste;

import br.ufc.edeajr.controllers.FormacaoController;
import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.FormacaoDAO;
import br.ufc.edeajr.model.Formacao;

public class FormacaoControllerTeste {

	private FormacaoController formacaoController;
	private FormacaoDAO formacaoDAO;
	private Validator validator;
	private Result result;

	@Before
	public void setUp() {
		formacaoDAO = Mockito.mock(FormacaoDAO.class);
		validator = Mockito.spy(new MockValidator());
		result = Mockito.spy(new MockResult());
		formacaoController = new FormacaoController(formacaoDAO, result, validator);
	}

	@Test
	public void adicionaFormacaoConsistenteTeste() throws DaoException {
		Formacao formacao = getFormacaoConsistente();
		formacaoController.adiciona(formacao);
		Mockito.verify(formacaoDAO).save(formacao);

	}

	@Test(expected = ValidationException.class)
	public void adicionaFormacaoInconsistenteTeste() {
		Formacao formacao = getFormacaoInconsistente();
		formacaoController.adiciona(formacao);
		Mockito.verifyNoMoreInteractions(formacaoDAO);

	}

	private Formacao getFormacaoConsistente() {
		Formacao formacao = new Formacao();
		formacao.setNome("Agronomia");
		return formacao;
	}

	private Formacao getFormacaoInconsistente() {
		Formacao formacao = new Formacao();
		return formacao;
	}
}