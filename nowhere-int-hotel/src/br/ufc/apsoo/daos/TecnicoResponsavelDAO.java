package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.TecnicoResponsavel;

@Component
public class TecnicoResponsavelDAO extends JPAGenericDao<TecnicoResponsavel, Long> implements IJPAGenericDao<TecnicoResponsavel, Long>{

	public TecnicoResponsavelDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}