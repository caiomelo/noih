package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Uf;

@Component
public class UfDAO extends JPAGenericDao<Uf, Long> implements IJPAGenericDao<Uf, Long>{

	public UfDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}