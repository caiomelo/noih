package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.RegistroVisita;

@Component
public class RegistroVisitaDAO extends JPAGenericDao<RegistroVisita, Long> implements IJPAGenericDao<RegistroVisita, Long>{

	public RegistroVisitaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
