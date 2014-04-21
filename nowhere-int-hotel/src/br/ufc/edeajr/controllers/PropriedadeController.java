package br.ufc.edeajr.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.MunicipioDAO;
import br.ufc.edeajr.daos.PropriedadeDAO;
import br.ufc.edeajr.daos.SetorDAO;
import br.ufc.edeajr.daos.TecnicoResponsavelDAO;
import br.ufc.edeajr.model.Municipio;
import br.ufc.edeajr.model.Propriedade;
import br.ufc.edeajr.model.Setor;
import br.ufc.edeajr.model.TecnicoResponsavel;

@Resource
public class PropriedadeController {

	private final PropriedadeDAO propriedadeDAO;
	private final MunicipioDAO municipioDAO;
	private final SetorDAO setorDAO;
	private final TecnicoResponsavelDAO tecnicoResponsavelDAO;
	private final Result result;
	private final Validator validator;

	public PropriedadeController(PropriedadeDAO propriedadeDAO,
			MunicipioDAO municipioDAO,TecnicoResponsavelDAO tecnicoResponsavelDAO, SetorDAO setorDAO,
			Result result, Validator validator) {
		this.propriedadeDAO = propriedadeDAO;
		this.municipioDAO = municipioDAO;
		this.setorDAO = setorDAO;
		this.tecnicoResponsavelDAO = tecnicoResponsavelDAO;
		this.result = result;
		this.validator = validator;
	}

	@Get @Path("propriedade/novo")
	public void formulario() {
		try {
			result.include("municipioList", municipioDAO.getAll());
			result.include("tecnicoResponsavelList", tecnicoResponsavelDAO.getAll());
			result.include("setorList", setorDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Post @Path("propriedade/novo")
	public void adiciona(Propriedade propriedade) {
		rotinaDeErro(propriedade);
		validator.onErrorUsePageOf(this).formulario();
		try {
			propriedade.setMunicipio(municipioDAO.findById(propriedade.getMunicipio().getId()));
			propriedade.setTecnicoResponsavel(tecnicoResponsavelDAO.findById(propriedade.getTecnicoResponsavel().getId()));
			propriedade.setSetor(setorDAO.findById(propriedade.getSetor().getId()));
			propriedadeDAO.save(propriedade);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		result.redirectTo(this).lista();

	}

	@Get @Path("propriedade/lista")
	public List<Propriedade> lista() {
		List<Propriedade> propriedadeList = null;
		try {
			propriedadeList = propriedadeDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propriedadeList;
	}
	
	@Get @Path("propriedade/edita/{id}")
	public Propriedade edita(Long id) {
		Propriedade propriedade = null;
		try {
			propriedade = propriedadeDAO.findById(id);
			if(propriedade != null) {
				result.include("municipioList", municipioDAO.getAll());
				result.include("tecnicoResponsavelList", tecnicoResponsavelDAO.getAll());
				result.include("setorList", setorDAO.getAll());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propriedade;
	}
	
	@Put @Path("propriedade/edita/{propriedade.id}")
	public void atualiza(Propriedade propriedade) {
		rotinaDeErro(propriedade);
		validator.onErrorUsePageOf(this).edita(propriedade.getId());
		try {
			propriedade.setMunicipio(municipioDAO.findById(propriedade.getMunicipio().getId()));
			propriedade.setTecnicoResponsavel(tecnicoResponsavelDAO.findById(propriedade.getTecnicoResponsavel().getId()));
			propriedade.setSetor(setorDAO.findById(propriedade.getSetor().getId()));
			propriedadeDAO.mergeEntity(propriedade);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}
	
	private void valida(Propriedade propriedade) {
		
		if(propriedade.getTipo() != null && !propriedade.getTipo().equals("LAB")
				&& !propriedade.getTipo().equals("FAZ") && !propriedade.getTipo().equals("BNF")
				&& !propriedade.getTipo().equals("OUT")) {
			//Erro adicionado com anotação na classe @NotEmtpy
			propriedade.setTipo(null);
		}
		
		if(propriedade.getMunicipio() == null || propriedade.getMunicipio().getId() == null || 
				propriedade.getMunicipio().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "municipio"));
		}
		
		if(propriedade.getTecnicoResponsavel() == null || propriedade.getTecnicoResponsavel().getId() == null || 
				propriedade.getTecnicoResponsavel().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "tecnicoResponsavel"));
		}
		
		if(propriedade.getSetor() == null || propriedade.getSetor().getId() == null || 
				propriedade.getSetor().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "setor"));
		}
		
		this.validator.validate(propriedade);
	}
	
	private void rotinaDeErro(Propriedade propriedade) {
		this.valida(propriedade);
		if(this.validator.hasErrors()) {
			try {
				List<Municipio> municipioList =  municipioDAO.getAll();
				
				//Setar o municipio no objeto propriedade
				if(propriedade.getMunicipio() != null && propriedade.getMunicipio().getId() != null 
						&& propriedade.getMunicipio().getId() > 0) {
					for(Municipio i : municipioList) {
						if(i.getId().longValue() == propriedade.getMunicipio().getId().longValue()) {
							propriedade.setMunicipio(i);
							break;
						}
					}
				}
				result.include("municipioList", municipioList);
				
				List<TecnicoResponsavel> tecnicoResponsavelList = tecnicoResponsavelDAO.getAll(); 
				//Setar o tecnicoResponsavel no objeto propriedade
				if(propriedade.getTecnicoResponsavel() != null && propriedade.getTecnicoResponsavel().getId() != null 
						&& propriedade.getTecnicoResponsavel().getId() > 0) {
					for(TecnicoResponsavel i : tecnicoResponsavelList) {
						if(i.getId().longValue() == propriedade.getTecnicoResponsavel().getId().longValue()) {
							propriedade.setTecnicoResponsavel(i);
							break;
						}
					}
				}
				result.include("tecnicoResponsavelList", tecnicoResponsavelList);
				
				List<Setor> setorList = setorDAO.getAll();
				//Setar o setor no objeto propriedade
				if(propriedade.getSetor() != null && propriedade.getSetor().getId() != null && propriedade.getSetor().getId() > 0) {
					for(Setor i : setorList) {
						if(i.getId().longValue() == propriedade.getSetor().getId().longValue()) {
							propriedade.setSetor(i);
							break;
						}
					}
				}
				result.include("setorList", setorList);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
