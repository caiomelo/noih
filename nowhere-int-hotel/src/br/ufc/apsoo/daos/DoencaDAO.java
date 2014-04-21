package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Doenca;

@Component
public class DoencaDAO extends JPAGenericDao<Doenca, Long> implements IJPAGenericDao<Doenca, Long>{

	public DoencaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}