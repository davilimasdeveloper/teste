package br.com.home.repository;

import java.util.List;

import br.com.home.model.CotacaoRespostaItem;
import br.com.home.utils.AbstractBase;

public class CotacaoRespostaItemRepository extends AbstractBase {

    public CotacaoRespostaItem buscarPorId(final Integer idCotacaoRespostaItem) throws Exception {
        CotacaoRespostaItem cotacaoRespostaItem = manager.find(CotacaoRespostaItem.class, idCotacaoRespostaItem);
        if (cotacaoRespostaItem == null) {
            throw new Exception("Cotacao De resposta Item " + idCotacaoRespostaItem + " não encontrada!");
        }
        return cotacaoRespostaItem;
    }

    public List<CotacaoRespostaItem> buscarPorPropriedade(final String whereClause, final Object parametro) {
        return manager.createQuery("select c from CotacaoRespostaItem c " + whereClause + parametro,
                CotacaoRespostaItem.class).getResultList();
    }

    public List<CotacaoRespostaItem> buscarTodos() {
        return manager.createQuery("select c from CotacaoRespostaItem c", CotacaoRespostaItem.class).getResultList();
    }

    public Long quantidadeComPropriedade(final String whereClause, final Object parametro) {
        return (Long) manager
                .createQuery(
                        "select COUNT(c.idCotacaoRespostaItem) from CotacaoRespostaItem c " + whereClause + parametro)
                .getSingleResult();
    }

}
