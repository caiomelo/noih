package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.ProblemaGeralDAO;
import br.ufc.apsoo.model.ProblemaGeral;

@Resource
public class ProblemaGeralController {

	private final ProblemaGeralDAO problemaGeralDAO;
	private final Result result;
	private final Validator validator;
	
	public ProblemaGeralController(ProblemaGeralDAO problemaGeralDAO, Result result, Validator validator) {
		this.problemaGeralDAO = problemaGeralDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("problemaGeral/novo")
	public void formulario() { }
	
	@Post @Path("problemaGeral/novo")
	public void adiciona(ProblemaGeral problemaGeral) {
		validator.validate(problemaGeral);
		validator.onErrorUsePageOf(this).formulario();
		try {
			problemaGeralDAO.save(problemaGeral);
		} catch (DaoException e) {
			System.out.println("Erro em problemaGeralDAO método save: " + e.getMessage());
		}
		result.redirectTo(this).lista();
	}
	
	@Get @Path("problemaGeral/lista")
	public List<ProblemaGeral> lista() {
		List<ProblemaGeral> problemaGeralList =  null;	
		try {
			problemaGeralList = problemaGeralDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em problemaGeralDAO método getAll: " + e.getMessage());
		}
		return problemaGeralList;
	}
	
	@Get @Path("problemaGeral/edita/{id}")
	public ProblemaGeral edita(Long id) {
		ProblemaGeral problemaGeral = null;
		try {
			problemaGeral = problemaGeralDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em problemaGeralDAO método findById: " + e.getMessage());
		}
		return problemaGeral;
	}
	
	@Put @Path("problemaGeral/edita/{problemaGeral.id}")
	public void atualiza(ProblemaGeral problemaGeral) {
		validator.validate(problemaGeral);
		validator.onErrorUsePageOf(this).edita(problemaGeral.getId());
		try {
			problemaGeralDAO.mergeEntity(problemaGeral);
		} catch (DaoException e) {
			System.out.println("Erro em problemaGeralDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O problema foi editado com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("problemaGeral/deleta/{id}")
	public void deleta(Long id) {
		try {
			problemaGeralDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em problemaGeralDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O problema foi deletado");
		result.redirectTo(this).lista();
	}
	
}
