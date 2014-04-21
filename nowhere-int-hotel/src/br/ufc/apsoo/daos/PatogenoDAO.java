package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Patogeno;

@Component
public class PatogenoDAO extends JPAGenericDao<Patogeno, Long> implements IJPAGenericDao<Patogeno, Long>{

	public PatogenoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
