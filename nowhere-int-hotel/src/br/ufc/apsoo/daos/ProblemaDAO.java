package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Problema;

@Component
public class ProblemaDAO extends JPAGenericDao<Problema, Long> implements IJPAGenericDao<Problema, Long>{

	public ProblemaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}