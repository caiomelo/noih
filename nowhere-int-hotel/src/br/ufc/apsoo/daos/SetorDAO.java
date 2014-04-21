package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Setor;

@Component
public class SetorDAO extends JPAGenericDao<Setor, Long> implements IJPAGenericDao<Setor, Long>{

	public SetorDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}