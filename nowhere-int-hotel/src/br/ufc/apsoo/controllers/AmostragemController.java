package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.AmostragemDAO;
import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.PropriedadeDAO;
import br.ufc.apsoo.model.Amostragem;
import br.ufc.apsoo.model.Propriedade;

@Resource
public class AmostragemController {
	private final AmostragemDAO amostragemDAO;
	private final PropriedadeDAO propriedadeDAO;
	private final Result result;
	private final Validator validator;
	
	public AmostragemController(AmostragemDAO amostragemDAO, PropriedadeDAO propriedadeDAO, Result result, Validator validator) {
		this.amostragemDAO = amostragemDAO;
		this.propriedadeDAO = propriedadeDAO;
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("amostragem/novo")
	public void formulario() {
		try {
			result.include("propriedadeList", propriedadeDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Post @Path("amostragem/novo")
	public void adiciona(Amostragem amostragem) {
		rotinaDeErro(amostragem);
		validator.onErrorUsePageOf(this).formulario();
		try {
			amostragem.setPropriedade(propriedadeDAO.findById(amostragem.getPropriedade().getId()));
			amostragemDAO.save(amostragem);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}
	
	@Get @Path("amostragem/lista")
	public List<Amostragem> lista() {
		List<Amostragem> amostragemList = null;
		try {
			amostragemList = amostragemDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amostragemList;
	}
	
	@Get @Path("amostragem/edita/{id}")
	public Amostragem edita(Long id) {
		Amostragem amostragem = null;
		try {
			amostragem = amostragemDAO.findById(id);
			if(amostragem != null) {
				result.include("propriedadeList", propriedadeDAO.getAll());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amostragem;
	}
	
	@Put @Path("amostragem/edita/{amostragem.id}")
	public void atualiza(Amostragem amostragem) {
		rotinaDeErro(amostragem);
		validator.onErrorUsePageOf(this).edita(amostragem.getId());
		try {
			amostragem.setPropriedade(propriedadeDAO.findById(amostragem.getPropriedade().getId()));
			amostragemDAO.mergeEntity(amostragem);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}
	
	private void valida(Amostragem amostragem) {
		if(amostragem.getPropriedade() == null || amostragem.getPropriedade().getId() == null 
				|| amostragem.getPropriedade().getId() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "propriedade"));
		}
		validator.validate(amostragem);
	}
	
	private void rotinaDeErro(Amostragem amostragem) {
		valida(amostragem);
		if(validator.hasErrors()) {	
			try {
				List<Propriedade> propriedadeList = propriedadeDAO.getAll();
				if(amostragem.getPropriedade() != null 
						&& amostragem.getPropriedade().getId() != null 
						&& amostragem.getPropriedade().getId() > 0) {
					for(Propriedade i : propriedadeList) {
						if(i.getId().longValue() == amostragem.getPropriedade().getId().longValue()) {
							amostragem.setPropriedade(i);
							break;
						}
					}
				}
				result.include("propriedadeList", propriedadeList);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
