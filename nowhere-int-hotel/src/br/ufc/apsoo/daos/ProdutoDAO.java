package br.ufc.apsoo.daos;

import br.ufc.apsoo.model.Produto;

@Component
public class ProdutoDAO extends JPAGenericDao<Produto, Long> implements IJPAGenericDao<Produto, Long>{

	public ProdutoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
