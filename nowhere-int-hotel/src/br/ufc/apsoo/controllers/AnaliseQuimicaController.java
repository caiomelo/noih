package br.ufc.apsoo.controllers;

import java.util.List;

import javax.annotation.Resource;

import br.ufc.apsoo.daos.AnaliseQuimicaDAO;
import br.ufc.apsoo.daos.DaoException;
import br.ufc.apsoo.daos.PropriedadeDAO;
import br.ufc.apsoo.model.AnaliseQuimica;
import br.ufc.apsoo.model.Propriedade;

@Resource
public class AnaliseQuimicaController {

	private final AnaliseQuimicaDAO analiseQuimicaDAO;
	private final PropriedadeDAO propriedadeDAO;
	private final Result result;
	private final Validator validator;

	public AnaliseQuimicaController(AnaliseQuimicaDAO analiseQuimicaDAO, PropriedadeDAO propriedadeDAO, Result result, Validator validator) {
		this.analiseQuimicaDAO = analiseQuimicaDAO;
		this.propriedadeDAO = propriedadeDAO;
		this.result = result;
		this.validator = validator;
	}

	@Get @Path("analiseQuimica/novo")
	public void formulario() {
		try {
			result.include("propriedadeList", propriedadeDAO.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Post @Path("analiseQuimica/novo")
	public void adiciona(AnaliseQuimica analiseQuimica) {
		rotinaDeErro(analiseQuimica);
		validator.onErrorUsePageOf(this).formulario();
		try {
			analiseQuimica.setPropriedade(propriedadeDAO.findById(analiseQuimica.getPropriedade().getId()));
			analiseQuimicaDAO.save(analiseQuimica);
		} catch (DaoException e) {
			System.out.println();
		}
		result.redirectTo(this).lista();
	}

	@Get @Path("analiseQuimica/lista")
	public List<AnaliseQuimica> lista() {
		List<AnaliseQuimica> analiseQuimicaList = null;
		try {
			analiseQuimicaList = analiseQuimicaDAO.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return analiseQuimicaList;
	}
	
	@Get @Path("analiseQuimica/edita/{id}")
	public AnaliseQuimica edita(Long id) {
		AnaliseQuimica analiseQuimica = null;
		try {
			analiseQuimica = analiseQuimicaDAO.findById(id);
			if(analiseQuimica != null) {
				result.include("propriedadeList", propriedadeDAO.getAll());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return analiseQuimica;
	}
	
	@Put @Path("analiseQuimica/edita/{analiseQuimica.id}")
	public void atualiza(AnaliseQuimica analiseQuimica) {
		rotinaDeErro(analiseQuimica);
		validator.onErrorUsePageOf(this).edita(analiseQuimica.getId());
		try {
			analiseQuimica.setPropriedade(propriedadeDAO.findById(analiseQuimica.getPropriedade().getId()));
			analiseQuimicaDAO.mergeEntity(analiseQuimica);
		} catch (DaoException e) {
			System.out.println();
		}
		result.redirectTo(this).lista();
	}
	
	private void valida(AnaliseQuimica analiseQuimica) {
		if(analiseQuimica.getPropriedade() == null || analiseQuimica.getPropriedade().getId() == null 
				|| analiseQuimica.getPropriedade().getId() <= 0) {
			validator.add(new ValidationMessage("Campo obrigatório", "propriedade"));
		}
		validator.validate(analiseQuimica);
	}
	
	private void rotinaDeErro(AnaliseQuimica analiseQuimica) {
		valida(analiseQuimica);
		if(validator.hasErrors()) {
	 		try {
	 			List<Propriedade> propriedadeList = propriedadeDAO.getAll();
	 			if(analiseQuimica.getPropriedade() != null 
						&& analiseQuimica.getPropriedade().getId() != null 
						&& analiseQuimica.getPropriedade().getId() > 0) {
					for(Propriedade i : propriedadeList) {
						if(i.getId().longValue() == analiseQuimica.getPropriedade().getId().longValue()) {
							analiseQuimica.setPropriedade(i);
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
