package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Municipio;

@Component
public class MunicipioDAO extends JPAGenericDao<Municipio, Long> implements IJPAGenericDao<Municipio, Long>{

	public MunicipioDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}