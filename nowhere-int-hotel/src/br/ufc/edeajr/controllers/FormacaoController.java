package br.ufc.edeajr.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.FormacaoDAO;
import br.ufc.edeajr.model.Formacao;

@Resource
public class FormacaoController {
	
	private final FormacaoDAO formacaoDAO;
	private final Result result;
	private final Validator validator;
	
	public FormacaoController(FormacaoDAO formacaoDAO, Result result, Validator validator) {
		this.formacaoDAO = formacaoDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("formacao/novo")
	public void formulario() { }
	
	@Post @Path("formacao/novo")
	public void adiciona(Formacao formacao) {
		validator.validate(formacao);
		validator.onErrorUsePageOf(this).formulario();
		try {
			formacaoDAO.save(formacao);
		} catch (DaoException e) {
			System.out.println("Erro em formacaoDAO método save: " + e.getMessage());
		}
		
		result.redirectTo(this).lista();
	}
	
	@Get @Path("formacao/lista")
	public List<Formacao> lista() {
		List<Formacao> lista =  null;
		
		try {
			lista = formacaoDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em formacaoDAO método getAll: " + e.getMessage());
		}
		
		return lista;
	}
	
	@Get @Path("formacao/edita/{id}")
	public Formacao edita(Long id) {
		Formacao formacao = null;
		try {
			formacao = formacaoDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em formacaoDAO método findById: " + e.getMessage());
		}
		return formacao;
	}
	
	@Put @Path("formacao/edita/{formacao.id}")
	public void atualiza(Formacao formacao) {
		validator.validate(formacao);
		validator.onErrorUsePageOf(this).edita(formacao.getId());
		try {
			formacaoDAO.mergeEntity(formacao);
		} catch (DaoException e) {
			System.out.println("Erro em formacaoDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "A formação editada com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("formacao/deleta/{id}")
	public void deleta(Long id) {
		try {
			formacaoDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em formacaoDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "A formação foi deletada");
		result.redirectTo(this).lista();
	}
}
