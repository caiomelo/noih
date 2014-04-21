package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.ParametroBiologico;

@Component
public class ParametroBiologicoDAO extends JPAGenericDao<ParametroBiologico, Long> implements IJPAGenericDao<ParametroBiologico, Long>{

	public ParametroBiologicoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
