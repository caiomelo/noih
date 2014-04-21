package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Tecido;

@Component
public class TecidoDAO extends JPAGenericDao<Tecido, Long> implements IJPAGenericDao<Tecido, Long>{

	public TecidoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}