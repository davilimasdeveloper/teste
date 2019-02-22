package br.com.home.repository;

import java.util.List;

import br.com.home.model.CotacaoItem;
import br.com.home.utils.AbstractBase;

public class CotacaoItemRepository extends AbstractBase {

    public CotacaoItem buscarPorId(final Integer idCotacaoItem) throws Exception {
        CotacaoItem cotacaoItem = manager.find(CotacaoItem.class, idCotacaoItem);
        if (cotacaoItem == null) {
            throw new Exception("Cotacao de item " + idCotacaoItem + " não encontrada!");
        }
        return cotacaoItem;
    }

    public List<CotacaoItem> buscarPorPropriedade(final String whereClause, final Object parametro) {
        return manager.createQuery("select c from CotacaoItem c " + whereClause + parametro, CotacaoItem.class)
                .getResultList();
    }

    public List<CotacaoItem> buscarTodos() {
        return manager.createQuery("select c from Cotacao c", CotacaoItem.class).getResultList();
    }

    public Long quantidadeComPropriedade(final String whereClause, final Object parametro) {
        return (Long) manager.createQuery("select COUNT(c.idCotacaoItem) from CotacaoItem c " + whereClause + parametro)
                .getSingleResult();
    }
}
