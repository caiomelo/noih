package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Laboratorio;

@Component
public class LaboratorioDAO extends JPAGenericDao<Laboratorio, Long> implements IJPAGenericDao<Laboratorio, Long>{

	public LaboratorioDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}