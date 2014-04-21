package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.MortalidadeRegistrada;

@Component
public class MortalidadeRegistradaDAO extends JPAGenericDao<MortalidadeRegistrada, Long> implements IJPAGenericDao<MortalidadeRegistrada, Long>{

	public MortalidadeRegistradaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}