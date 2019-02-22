package br.com.home.repository;

import java.util.List;


import br.com.home.model.Produto;
import br.com.home.utils.AbstractBase;

public class ProdutoRepository extends AbstractBase{

//	@PersistenceContext(unitName = "primary")
//	private EntityManager manager;

	public Produto buscarPorId(final Integer idProduto) throws Exception {
		Produto produto = manager.find(Produto.class, idProduto);
		if (produto == null) {
			throw new Exception("Produto " + idProduto + " não encontrada!");
		}
		return produto;
	}

	public List<Produto> buscarPorPropriedade(final String whereClause, final Object parametro) {
		return manager.createQuery("select p from Produto p " + whereClause + parametro, Produto.class).getResultList();
	}

	public List<Produto> buscarTodos() {
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public Long quantidadeComPropriedade(final String whereClause, final Object parametro) {
		return (Long) manager.createQuery("select COUNT(c.idProduto) from Produto p " + whereClause + parametro)
				.getSingleResult();
	}

}
