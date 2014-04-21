package br.ufc.apsoo.controllers;



import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.MunicipioDAO;
import br.ufc.apsoo.daos.UfDAO;
import br.ufc.apsoo.model.Municipio;
import br.ufc.apsoo.model.Uf;

@Resource
public class MunicipioController {

	private final MunicipioDAO municipioDAO;
	private final UfDAO ufDAO;
	private final Result result;
	private final Validator validator;
	
	public MunicipioController(MunicipioDAO municipioDAO, UfDAO ufDAO, Result result, Validator validator) {
		this.municipioDAO = municipioDAO;
		this.ufDAO = ufDAO;
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("municipio/novo")
	public void formulario() {
		try {
			result.include("ufList", ufDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Post @Path("municipio/novo")
	public void adiciona(Municipio municipio) {
		rotinaDeErro(municipio);
		validator.onErrorUsePageOf(this).formulario();
		
		try {
			municipio.setUf(ufDAO.findById(municipio.getUf().getId()));
			municipioDAO.save(municipio);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		result.redirectTo(this).lista();	
	}
	
	@Get @Path("municipio/edita/{id}")
	public Municipio edita(Long id) {
		Municipio municipio = null;
		try {
			municipio = municipioDAO.findById(id);
			result.include("ufList", ufDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return municipio;
	}
	
	@Put @Path("municipio/edita/{municipio.id}")
	public void atualiza(Municipio municipio) {
		rotinaDeErro(municipio);
		validator.onErrorUsePageOf(this).edita(municipio.getId());
		try {
			municipio.setUf(ufDAO.findById(municipio.getUf().getId()));
			municipioDAO.mergeEntity(municipio);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("municipio/deleta/{id}")
	public void deleta(Long id) {
		try {
			municipioDAO.deleteEntity(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.include("mensagemDaLogica", "O município foi deletado.");
		result.redirectTo(this).lista();
		
	}
	
	@Get @Path("municipio/lista")
	public List<Municipio> lista() {
		List<Municipio> municipioList = null;
		try {
			municipioList =  municipioDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return municipioList;
	}
	
	
	private void valida(Municipio municipio) {
		if(municipio.getUf() == null || municipio.getUf().getId() == null 
				|| municipio.getUf().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "uf"));
		}
		validator.validate(municipio);
	}
	
	private void rotinaDeErro(Municipio municipio) {
		valida(municipio);
		if(validator.hasErrors()) {
			try {
				List<Uf> ufList = ufDAO.getAll();
				if(municipio.getUf() != null && municipio.getUf().getId() != null && municipio.getUf().getId().longValue() > 0) {
					for(Uf i : ufList) {
						if(i.getId().longValue() == municipio.getUf().getId().longValue()) {
							municipio.setUf(i);
							break;
						}
					}
				}
				result.include("ufList", ufList);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
