package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.ProblemaGeral;

@Component
public class ProblemaGeralDAO extends JPAGenericDao<ProblemaGeral, Long> implements IJPAGenericDao<ProblemaGeral, Long>{

	public ProblemaGeralDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}