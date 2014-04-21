package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.DoencaDAO;
import br.ufc.apsoo.model.Doenca;

@Resource
public class DoencaController {
	
	private final DoencaDAO doencaDAO;
	private final Result result;
	private final Validator validator;
	
	public DoencaController(DoencaDAO doencaDAO, Result result, Validator validator) {
		this.doencaDAO = doencaDAO;
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("doenca/novo")
	public void formulario() { }
		
	@Post @Path("doenca/novo")
	public void adiciona(Doenca doenca) {
		validator.validate(doenca);
		validator.onErrorUsePageOf(this).formulario();
		try {
			doencaDAO.save(doenca);
		} catch (DaoException e) {
			System.out.println("Erro em DoencaController no método adiciona" + e.getMessage());
		}	
		result.redirectTo(this).lista();
	}
	
	@Get @Path("doenca/lista")
	public List<Doenca> lista() {
		List<Doenca> doencaList = null;
		try {
			doencaList = doencaDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em DoencaController no método lista" + e.getMessage());
		}
		return doencaList;
	}
	
	@Get @Path("doenca/edita/{id}")
	public Doenca edita(Long id) {
		Doenca doenca = null;
		try {
			doenca = doencaDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em DoencaController no método edita" + e.getMessage());
		}
		return doenca;
	}
	
	@Put @Path("doenca/edita/{doenca.id}")
	public void atualiza(Doenca doenca) {
		validator.validate(doenca);
		validator.onErrorUsePageOf(this).formulario();
		try {
			doencaDAO.mergeEntity(doenca);
		} catch (DaoException e) {
			System.out.println("Erro em DoencaController no método atualiza" + e.getMessage());
		}	
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("doenca/deleta/{id}")
	public void deleta(Long id) {
		try {
			doencaDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em DoencaController no método deleta" + e.getMessage());
		}
		result.redirectTo(this).lista();
	}
}
