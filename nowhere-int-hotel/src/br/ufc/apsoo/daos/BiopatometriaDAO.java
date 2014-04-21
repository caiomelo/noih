package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Biopatometria;

@Component
public class BiopatometriaDAO extends JPAGenericDao<Biopatometria, Long> implements IJPAGenericDao<Biopatometria, Long>{

	public BiopatometriaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}