package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Formacao;

@Component
public class FormacaoDAO extends JPAGenericDao<Formacao, Long> implements IJPAGenericDao<Formacao, Long>{

	public FormacaoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}