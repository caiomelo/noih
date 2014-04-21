package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Patogeno;

@Component
public class PatogenoDAO extends JPAGenericDao<Patogeno, Long> implements IJPAGenericDao<Patogeno, Long>{

	public PatogenoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
