package br.ufc.edeajr.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.SetorDAO;
import br.ufc.edeajr.model.Setor;

@Resource
public class SetorController {
	
	private final SetorDAO setorDAO;
	private final Result result;
	private final Validator validator;
	
	public SetorController(SetorDAO setorDAO, Result result, Validator validator) {
		this.setorDAO = setorDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("setor/novo")
	public void formulario() { }
	
	@Post @Path("setor/novo")
	public void adiciona(Setor setor) {
		validator.validate(setor);
		validator.onErrorUsePageOf(this).formulario();
		
		try {
			setorDAO.save(setor);
		} catch (DaoException e) {
			System.out.println("Erro em setorDAO método save: " + e.getMessage());
		}
		
		result.redirectTo(this).lista();
	}
	
	@Get @Path("setor/lista")
	public List<Setor> lista() {
		List<Setor> setorList = null;
		try {
			setorList = setorDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em setorDAO método getAll: " + e.getMessage());
		}
		return setorList;
	}
	
	@Get @Path("setor/edita/{id}")
	public Setor edita(Long id) {
		Setor setor = null;
		try {
			setor = setorDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em setorDAO método findById: " + e.getMessage());
		}
		return setor;
	}
	
	@Put @Path("setor/edita/{setor.id}")
	public void atualiza(Setor setor) {
		validator.validate(setor);
		validator.onErrorUsePageOf(this).edita(setor.getId());
		try {
			setorDAO.mergeEntity(setor);
		} catch (DaoException e) {
			System.out.println("Erro em setorDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O setor foi editado com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("setor/deleta/{id}")
	public void deleta(Long id) {
		try {
			setorDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em setorDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O setor foi deletado com sucesso");
		result.redirectTo(this).lista();
	}


}
