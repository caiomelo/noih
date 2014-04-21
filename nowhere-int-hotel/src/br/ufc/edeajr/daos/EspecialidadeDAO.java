package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Especialidade;

@Component
public class EspecialidadeDAO extends JPAGenericDao<Especialidade, Long> implements IJPAGenericDao<Especialidade, Long>{

	public EspecialidadeDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}