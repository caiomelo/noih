package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Setor;

@Component
public class SetorDAO extends JPAGenericDao<Setor, Long> implements IJPAGenericDao<Setor, Long>{

	public SetorDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}