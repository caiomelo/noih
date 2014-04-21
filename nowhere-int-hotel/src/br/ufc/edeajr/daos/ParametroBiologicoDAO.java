package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.ParametroBiologico;

@Component
public class ParametroBiologicoDAO extends JPAGenericDao<ParametroBiologico, Long> implements IJPAGenericDao<ParametroBiologico, Long>{

	public ParametroBiologicoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
