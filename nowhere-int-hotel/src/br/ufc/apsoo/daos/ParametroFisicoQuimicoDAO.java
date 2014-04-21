package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.ParametroFisicoQuimico;

@Component
public class ParametroFisicoQuimicoDAO extends JPAGenericDao<ParametroFisicoQuimico, Long> implements IJPAGenericDao<ParametroFisicoQuimico, Long>{

	public ParametroFisicoQuimicoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
