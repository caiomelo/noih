package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Diagnostico;

@Component
public class DiagnosticoDAO extends JPAGenericDao<Diagnostico, Long> implements IJPAGenericDao<Diagnostico, Long>{

	public DiagnosticoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}