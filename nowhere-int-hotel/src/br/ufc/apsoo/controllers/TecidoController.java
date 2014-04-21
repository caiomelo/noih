package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.TecidoDAO;
import br.ufc.apsoo.model.Tecido;

@Resource
public class TecidoController {
	
	private final TecidoDAO tecidoDAO;
	private final Result result;
	private final Validator validator;
	
	public TecidoController(TecidoDAO tecidoDAO, Result result, Validator validator) {
		this.tecidoDAO = tecidoDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("tecido/novo")
	public void formulario() { }
	
	@Post @Path("tecido/novo")
	public void adiciona(Tecido tecido) {
		validator.validate(tecido);
		validator.onErrorUsePageOf(this).formulario();
		
		try {
			tecidoDAO.save(tecido);
		} catch (DaoException e) {
			System.out.println("Erro em tecidoDAO método save: " + e.getMessage());
		}
		
		result.redirectTo(this).lista();
	}
	
	@Get @Path("tecido/lista")
	public List<Tecido> lista() {
		List<Tecido> tecidoList =  null;
		try {
			tecidoList = tecidoDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em tecidoDAO método getAll: " + e.getMessage());
		}
		return tecidoList;
	}
	
	@Get @Path("tecido/edita/{id}")
	public Tecido edita(Long id) {
		Tecido tecido = null;
		try {
			tecido = tecidoDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em tecidoDAO método findById: " + e.getMessage());
		}
		return tecido;
	}
	
	@Put @Path("tecido/edita/{tecido.id}")
	public void atualiza(Tecido tecido) {
		validator.validate(tecido);
		validator.onErrorUsePageOf(this).edita(tecido.getId());
		try {
			tecidoDAO.mergeEntity(tecido);
		} catch (DaoException e) {
			System.out.println("Erro em tecidoDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O tecido foi editado com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("tecido/deleta/{id}")
	public void deleta(Long id) {
		try {
			tecidoDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em tecidoDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "O tecido foi deletado com sucesso");
		result.redirectTo(this).lista();
	}
	
}
