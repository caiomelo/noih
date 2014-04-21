package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Propriedade;

@Component
public class PropriedadeDAO extends JPAGenericDao<Propriedade, Long> implements IJPAGenericDao<Propriedade, Long>{

	public PropriedadeDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}