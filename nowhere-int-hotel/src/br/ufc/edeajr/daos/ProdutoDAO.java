package br.ufc.edeajr.daos;

import br.ufc.edeajr.model.Produto;

@Component
public class ProdutoDAO extends JPAGenericDao<Produto, Long> implements IJPAGenericDao<Produto, Long>{

	public ProdutoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
