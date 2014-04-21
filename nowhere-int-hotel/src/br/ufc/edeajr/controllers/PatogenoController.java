package br.ufc.edeajr.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.PatogenoDAO;
import br.ufc.edeajr.model.Patogeno;

@Resource
public class PatogenoController {
	
	private final PatogenoDAO patogenoDAO;
	private final Result result;
	private final Validator validator;
	
	public PatogenoController(PatogenoDAO patogenoDAO, Result result, Validator validator) {
		this.patogenoDAO = patogenoDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("patogeno/novo")
	public void formulario() { }
	
	@Post @Path("patogeno/novo")
	public void adiciona(Patogeno patogeno) {
		validator.validate(patogeno);
		validator.onErrorUsePageOf(this).formulario();
		
		try {
			patogenoDAO.save(patogeno);
		} catch (DaoException e) {
			System.out.println("Erro em patogenoDAO método save: " + e.getMessage());
		}
		
		result.redirectTo(this).lista();
	}
	
	@Get @Path("patogeno/lista")
	public List<Patogeno> lista() {
		List<Patogeno> patogenoList =  null;	
		try {
			patogenoList = patogenoDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em patogenoDAO método getAll: " + e.getMessage());
		}
		return patogenoList;
	}
	
	@Get @Path("patogeno/edita/{id}")
	public Patogeno edita(Long id) {
		Patogeno patogeno = null;
		try {
			patogeno = patogenoDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em patogenoDAO método findById: " + e.getMessage());
		}
		return patogeno;
	}
	
	@Put @Path("patogeno/edita/{patogeno.id}")
	public void atualiza(Patogeno patogeno) {
		validator.validate(patogeno);
		validator.onErrorUsePageOf(this).edita(patogeno.getId());
		try {
			patogenoDAO.mergeEntity(patogeno);
		} catch (DaoException e) {
			System.out.println("Erro em patogenoDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "A formação editada com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("patogeno/deleta/{id}")
	public void deleta(Long id) {
		try {
			patogenoDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em patogenoDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "A formação foi deletada");
		result.redirectTo(this).lista();
	}
}

