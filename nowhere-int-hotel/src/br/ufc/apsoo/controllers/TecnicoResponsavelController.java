package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.EspecialidadeDAO;
import br.ufc.apsoo.daos.FormacaoDAO;
import br.ufc.apsoo.daos.TecnicoResponsavelDAO;
import br.ufc.apsoo.model.Especialidade;
import br.ufc.apsoo.model.Formacao;
import br.ufc.apsoo.model.TecnicoResponsavel;

@Resource
public class TecnicoResponsavelController {

	private final TecnicoResponsavelDAO tecnicoResponsavelDAO;
	private final FormacaoDAO formacaoDAO;
	private final EspecialidadeDAO especialidadeDAO;
	private final Result result;
	private final Validator validator;

	public TecnicoResponsavelController(TecnicoResponsavelDAO tecnicoResponsavelDAO, FormacaoDAO formacaoDAO, EspecialidadeDAO especialidadeDAO, Result result, Validator validator) {
		this.tecnicoResponsavelDAO = tecnicoResponsavelDAO;
		this.formacaoDAO = formacaoDAO;
		this.especialidadeDAO = especialidadeDAO;
		this.result = result;
		this.validator = validator;
	}

	@Get @Path("tecnicoResponsavel/novo")
	public void formulario() {
		try {
			result.include("formacaoList", formacaoDAO.getAll());
			result.include("especialidadeList", especialidadeDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Post @Path("tecnicoResponsavel/novo")
	public void adiciona(TecnicoResponsavel tecnicoResponsavel) {
		rotinaDeErro(tecnicoResponsavel);
		validator.onErrorUsePageOf(this).formulario();
		try {
			
			tecnicoResponsavel.setFormacao(formacaoDAO.findById(tecnicoResponsavel.getFormacao().getId()));
			
			Especialidade especialidade = null;
			
			if(tecnicoResponsavel.getEspecialidade1().getId() != null && tecnicoResponsavel.getEspecialidade1().getId().longValue() > 0) {
				especialidade = especialidadeDAO.findById(tecnicoResponsavel.getEspecialidade1().getId());
			}
			
			tecnicoResponsavel.setEspecialidade1(especialidade);
			
			especialidade = null;
			
			if(tecnicoResponsavel.getEspecialidade2().getId() != null && tecnicoResponsavel.getEspecialidade2().getId().longValue() > 0) {
				especialidade = especialidadeDAO.findById(tecnicoResponsavel.getEspecialidade2().getId());
			}
			
			tecnicoResponsavel.setEspecialidade2(especialidade);
			
			tecnicoResponsavelDAO.save(tecnicoResponsavel);
		} catch (DaoException e) {
			System.out.println();
		}

		result.redirectTo(this).lista();
	}

	
	@Get @Path("tecnicoResponsavel/edita/{id}")
	public TecnicoResponsavel edita(Long id) {
		TecnicoResponsavel tecnicoResponsavel = null;
		try {
			tecnicoResponsavel = tecnicoResponsavelDAO.findById(id); 
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tecnicoResponsavel != null) {
			try {
				System.out.println("aqui");
				result.include("formacaoList", formacaoDAO.getAll());
				result.include("especialidadeList", especialidadeDAO.getAll());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tecnicoResponsavel;
	}
	
	
	@Put @Path("tecnicoResponsavel/edita/{tecnicoResponsavel.id}")
	public void atualiza(TecnicoResponsavel tecnicoResponsavel) {
		rotinaDeErro(tecnicoResponsavel);
		validator.onErrorUsePageOf(this).edita(tecnicoResponsavel.getId());
		//TODO Verificar se teste de especialidade é obrigatório
		try {	
			tecnicoResponsavel.setFormacao(formacaoDAO.findById(tecnicoResponsavel.getFormacao().getId()));
			
			Especialidade especialidade = null;
			
			if(tecnicoResponsavel.getEspecialidade1().getId() != null && tecnicoResponsavel.getEspecialidade1().getId().longValue() > 0) {
				especialidade = especialidadeDAO.findById(tecnicoResponsavel.getEspecialidade1().getId());
			}
			
			tecnicoResponsavel.setEspecialidade1(especialidade);
			
			especialidade = null;
			
			if(tecnicoResponsavel.getEspecialidade2().getId() != null && tecnicoResponsavel.getEspecialidade2().getId().longValue() > 0) {
				especialidade = especialidadeDAO.findById(tecnicoResponsavel.getEspecialidade2().getId());
			}
			
			tecnicoResponsavel.setEspecialidade2(especialidade);
			
			tecnicoResponsavelDAO.mergeEntity(tecnicoResponsavel);
		} catch (DaoException e) {
			System.out.println();
		}

		result.redirectTo(this).lista();
	}
	
	@Get @Path("tecnicoResponsavel/lista")
	public List<TecnicoResponsavel> lista() {
		List<TecnicoResponsavel> tecnicoResponsavelList = null;
		try {
			tecnicoResponsavelList = tecnicoResponsavelDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tecnicoResponsavelList;
	}
	private void valida(TecnicoResponsavel tecnicoResponsavel) {
		if((tecnicoResponsavel.getFormacao().getId() == null) || tecnicoResponsavel.getFormacao().getId() == null 
				|| tecnicoResponsavel.getFormacao().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "formacao"));
		}
		
		/* Validações de especialidade
		if(tecnicoResponsavel.getEspecialidade1() == null || tecnicoResponsavel.getEspecialidade1().getId() == null 
				|| tecnicoResponsavel.getEspecialidade1().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "especialidade1"));
		}
		
		if(tecnicoResponsavel.getEspecialidade2() == null || tecnicoResponsavel.getEspecialidade2().getId() == null 
				|| tecnicoResponsavel.getEspecialidade2().getId().longValue() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "especialidade2"));
		}
		
		*/
		validator.validate(tecnicoResponsavel);
	}
	
	private void rotinaDeErro(TecnicoResponsavel tecnicoResponsavel) {
		valida(tecnicoResponsavel);
		if(validator.hasErrors()) {	
			try {
				List<Formacao> formacaoList = formacaoDAO.getAll();
				
				if(tecnicoResponsavel.getFormacao().getId() != null && tecnicoResponsavel.getFormacao().getId().longValue() > 0) {
					for(Formacao i : formacaoList) {
						if(i.getId().longValue() == tecnicoResponsavel.getFormacao().getId().longValue()) {
							tecnicoResponsavel.setFormacao(i);
							break;
						}
					}
				}
				result.include("formacaoList", formacaoList);
				
				List<Especialidade> especialidadeList = especialidadeDAO.getAll();
				if(tecnicoResponsavel.getEspecialidade1().getId() != null && tecnicoResponsavel.getEspecialidade1().getId().longValue() > 0) {
					for(Especialidade i : especialidadeList) {
						if(i.getId().longValue() == tecnicoResponsavel.getEspecialidade1().getId().longValue()) {
							tecnicoResponsavel.setEspecialidade1(i);
							break;
						}
					}
				}
				
				if(tecnicoResponsavel.getEspecialidade2().getId() != null && tecnicoResponsavel.getEspecialidade2().getId().longValue() > 0) {
					for(Especialidade i : especialidadeList) {
						if(i.getId().longValue() == tecnicoResponsavel.getEspecialidade2().getId().longValue()) {
							tecnicoResponsavel.setEspecialidade2(i);
							break;
						}
					}
				}
				
				result.include("especialidadeList", especialidadeList);
				
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
