package br.com.home.repository;

import java.util.List;

import br.com.home.model.Cotacao;
import br.com.home.utils.AbstractBase;

public class CotacaoRepository extends AbstractBase {

    public Cotacao buscarPorId(final Integer idCotacao) {
        Cotacao cotacao = manager.find(Cotacao.class, idCotacao);
        if (cotacao == null) {
            throw new RuntimeException("Cotacao " + idCotacao + " não encontrada!");
        }
        return cotacao;
    }

    public List<Cotacao> buscarPorPropriedade(final String whereClause, final Object parametro) {
        return manager.createQuery("select c from Cotacao c " + whereClause + parametro, Cotacao.class).getResultList();
    }

    public List<Cotacao> buscarTodos() {
        return manager.createQuery("select c from Cotacao c", Cotacao.class).getResultList();
    }

    public Long quantidadeComPropriedade(final String whereClause, final Object parametro) {
        return (Long) manager.createQuery("select COUNT(c.idCotacao) from Cotacao c " + whereClause + parametro)
                .getSingleResult();
    }
}
