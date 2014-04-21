package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.ManejoUnidadeProducao;

@Component
public class ManejoUnidadeProducaoDAO extends JPAGenericDao<ManejoUnidadeProducao, Long> implements IJPAGenericDao<ManejoUnidadeProducao, Long>{

	public ManejoUnidadeProducaoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
