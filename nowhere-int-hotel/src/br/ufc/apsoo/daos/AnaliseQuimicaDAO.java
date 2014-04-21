package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.AnaliseQuimica;

@Component
public class AnaliseQuimicaDAO extends JPAGenericDao<AnaliseQuimica, Long> implements IJPAGenericDao<AnaliseQuimica, Long>{

	public AnaliseQuimicaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}