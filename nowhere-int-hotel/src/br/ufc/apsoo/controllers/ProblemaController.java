package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.ProblemaDAO;
import br.ufc.apsoo.model.Problema;

@Resource
public class ProblemaController {
	
	private final ProblemaDAO problemaDAO;
	private final Result result;
	private final Validator validator;
	
	public ProblemaController(ProblemaDAO problemaDAO, Result result, Validator validator) {
		this.problemaDAO = problemaDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("problema/novo")
	public void formulario() { }
	
	@Post @Path("problema/novo")
	public void adiciona(Problema problema) {
		validator.validate(problema);
		validator.onErrorUsePageOf(this).formulario();
		try {
			problemaDAO.save(problema);
		} catch (DaoException e) {
			System.out.println("Erro em problemaDAO método save: " + e.getMessage());
		}
		
		result.redirectTo(this).lista();
	}
	
	@Get @Path("problema/lista")
	public List<Problema> lista() {
		List<Problema> problemaList =  null;
		try {
			problemaList = problemaDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em problemaDAO método getAll: " + e.getMessage());
		}
		return problemaList;
	}
	
	@Get @Path("problema/edita/{id}")
	public Problema edita(Long id) {
		Problema problema = null;
		try {
			problema = problemaDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em problemaDAO método findById: " + e.getMessage());
		}
		return problema;
	}
	
	@Put @Path("problema/edita/{problema.id}")
	public void atualiza(Problema problema) {
		validator.validate(problema);
		validator.onErrorUsePageOf(this).edita(problema.getId());
		try {
			problemaDAO.mergeEntity(problema);
		} catch (DaoException e) {
			System.out.println("Erro em problemaDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O Problema foi editado com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("problema/deleta/{id}")
	public void deleta(Long id) {
		try {
			problemaDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em problemaDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O problema foi deletada");
		result.redirectTo(this).lista();
	}

}
