package br.ufc.edeajr.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.edeajr.daos.BiopatometriaDAO;
import br.ufc.edeajr.daos.DaoException;
import br.ufc.edeajr.daos.ProblemaDAO;
import br.ufc.edeajr.daos.PropriedadeDAO;
import br.ufc.edeajr.daos.TecnicoResponsavelDAO;
import br.ufc.edeajr.model.Biopatometria;
import br.ufc.edeajr.model.Problema;
import br.ufc.edeajr.model.Propriedade;

@Resource
public class BiopatometriaController {
	
	private final BiopatometriaDAO biopatometriaDAO;
	private final PropriedadeDAO propriedadeDAO;
	private final ProblemaDAO problemaDAO;
	private final Result result;
	private final Validator validator;
	
	public BiopatometriaController(BiopatometriaDAO biopatometriaDAO, PropriedadeDAO propriedadeDAO, 
			ProblemaDAO problemaDAO, TecnicoResponsavelDAO tecnicoResponsavelDAO, Result result, Validator validator) {
		this.biopatometriaDAO = biopatometriaDAO;
		this.propriedadeDAO = propriedadeDAO;
		this.problemaDAO = problemaDAO;
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("biopatometria/novo")
	public void formulario() { 
		try {
			result.include("propriedadeList", propriedadeDAO.getAll());
			result.include("problemaList", problemaDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Post @Path("biopatometria/novo")
	public void adiciona(Biopatometria biopatometria) {
		rotinaDeErro(biopatometria);
		validator.onErrorUsePageOf(this).formulario();
		try {
			biopatometria.setPropriedade(propriedadeDAO.findById(biopatometria.getPropriedade().getId()));
			biopatometria.setProblema(problemaDAO.findById(biopatometria.getProblema().getId()));
			biopatometriaDAO.save(biopatometria);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}
	
	@Get @Path("biopatometria/lista")
	public List<Biopatometria> lista() {
		List<Biopatometria> biopatometriaList = null;
		try {
			biopatometriaList = biopatometriaDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return biopatometriaList;
	}

	
	@Get @Path("biopatometria/edita/{id}") 
	public Biopatometria edita(Long id){
		Biopatometria biopatometria = null;
		try {
			result.include("propriedadeList", propriedadeDAO.getAll());
			result.include("problemaList", problemaDAO.getAll());
			biopatometria = biopatometriaDAO.findById(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return biopatometria;
	}
	
	@Put @Path("biopatometria/edita/{biopatometria.id}")
	public void atualiza(Biopatometria biopatometria) {
		rotinaDeErro(biopatometria);
		validator.onErrorUsePageOf(this).edita(biopatometria.getId());
		try {
			biopatometria.setPropriedade(propriedadeDAO.findById(biopatometria.getPropriedade().getId()));
			biopatometria.setProblema(problemaDAO.findById(biopatometria.getProblema().getId()));
			biopatometriaDAO.mergeEntity(biopatometria);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		result.redirectTo(this).lista();
	}
	
	private void valida(Biopatometria biopatometria) { 
		if(biopatometria.getPropriedade() == null || biopatometria.getPropriedade().getId() == null
				|| biopatometria.getPropriedade().getId() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "propriedade"));
		}
		
		if(biopatometria.getProblema() == null || biopatometria.getProblema().getId() == null 
				|| biopatometria.getProblema().getId() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "problema"));
		}
		
		if(biopatometria.getGrauSeveridade() != 1 && biopatometria.getGrauSeveridade() != 2
				&& biopatometria.getGrauSeveridade() != 3 && biopatometria.getGrauSeveridade() != 4) {
			validator.add(new ValidationMessage("Campo obrigatório", "grauSeveridade"));
		}
		
		validator.validate(biopatometria);
	}
	
	private void rotinaDeErro(Biopatometria biopatometria) {
		valida(biopatometria);
		if(validator.hasErrors()) {
			try {
				List<Propriedade> propriedadeList = propriedadeDAO.getAll();
				if(biopatometria.getPropriedade() != null && biopatometria.getPropriedade().getId() != null 
						&& biopatometria.getPropriedade().getId().longValue() > 0) {
					for(Propriedade i : propriedadeList) {
						if(i.getId().longValue() == biopatometria.getPropriedade().getId().longValue()) {
							biopatometria.setPropriedade(i);
							break;
						}
					}
				}
				result.include("propriedadeList", propriedadeList);
			
				List<Problema> problemaList = problemaDAO.getAll();
				if(biopatometria.getProblema() != null && biopatometria.getProblema().getId() != null 
						&& biopatometria.getProblema().getId().longValue() > 0) {
					for(Problema i : problemaList) {
						if(i.getId().longValue() == biopatometria.getProblema().getId().longValue()) {
							biopatometria.setProblema(i);
							break;
						}
					}
				}
				result.include("problemaList", problemaList);
				
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

