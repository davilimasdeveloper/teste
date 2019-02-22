package br.com.home.service;

import br.com.home.utils.AbstractBase;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.home.model.Produto;
import br.com.home.repository.ProdutoRepository;

@Stateless
public class ProdutoService extends AbstractBase {

    @Inject
    private ProdutoRepository repository;

    public Produto atualizar(final Produto produto) {
        manager.merge(produto);
        return produto;
    }

    public void deletar(final Integer idProduto) throws Exception {
        Produto produto = repository.buscarPorId(idProduto);
        if (produto != null) {
            manager.remove(produto);
        } else {
            throw new Exception("Produto não encontrado!");
        }
    }

    public Produto salvar(final Produto produto) {
        manager.persist(produto);
        return produto;
    }

}
