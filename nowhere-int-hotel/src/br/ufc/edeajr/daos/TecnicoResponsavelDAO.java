package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.TecnicoResponsavel;

@Component
public class TecnicoResponsavelDAO extends JPAGenericDao<TecnicoResponsavel, Long> implements IJPAGenericDao<TecnicoResponsavel, Long>{

	public TecnicoResponsavelDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}