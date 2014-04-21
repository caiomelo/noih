package br.ufc.edeajr.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.EspecialidadeDAO;
import br.ufc.edeajr.model.Especialidade;

@Resource
public class EspecialidadeController {
	
	private final EspecialidadeDAO especialidadeDAO;
	private final Result result;
	private final Validator validator;
	
	public EspecialidadeController(EspecialidadeDAO especialidadeDAO, Result result, Validator validator) {
		this.especialidadeDAO = especialidadeDAO;			
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("especialidade/novo")
	public void formulario() { }
	
	@Post @Path("especialidade/novo")
	public void adiciona(Especialidade especialidade) {
		validator.validate(especialidade);
		validator.onErrorUsePageOf(this).formulario();
		try {
			especialidadeDAO.save(especialidade);
		} catch (DaoException e) {
			System.out.println("Erro em especialidadeDAO método save: " + e.getMessage());
		}
		
		result.redirectTo(this).lista();
	}
	
	@Get @Path("especialidade/lista")
	public List<Especialidade> lista() {
		List<Especialidade> lista =  null;
		
		try {
			lista = especialidadeDAO.getAll();
		} catch (DaoException e) {
			System.out.println("Erro em especialidadeDAO método getAll: " + e.getMessage());
		}
		
		return lista;
	}
	
	@Get @Path("especialidade/edita/{id}")
	public Especialidade edita(Long id) {
		Especialidade especialidade = null;
		try {
			especialidade = especialidadeDAO.findById(id);
		} catch (DaoException e) {
			System.out.println("Erro em especialidadeDAO método findById: " + e.getMessage());
		}
		return especialidade;
	}
	
	
	@Put @Path("especialidade/edita/{especialidade.id}")
	public void atualiza(Especialidade especialidade) {
		validator.validate(especialidade);
		validator.onErrorUsePageOf(this).edita(especialidade.getId());
		try {
			especialidadeDAO.mergeEntity(especialidade);
		} catch (DaoException e) {
			System.out.println("Erro em especialidadeDAO método mergeEntity: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "A especialidade foi editada com sucesso");
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("especialidade/deleta/{id}")
	public void deleta(Long id) {
		try {
			especialidadeDAO.deleteEntity(id);
		} catch (DaoException e) {
			System.out.println("Erro em especialidadeDAO método delete: " + e.getMessage());
		}
		result.include("mensagemDaLogica", "A especialidade foi deletada");
		result.redirectTo(this).lista();
	}
}
