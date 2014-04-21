package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Amostragem;

@Component
public class AmostragemDAO extends JPAGenericDao<Amostragem, Long> implements IJPAGenericDao<Amostragem, Long>{

	public AmostragemDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}