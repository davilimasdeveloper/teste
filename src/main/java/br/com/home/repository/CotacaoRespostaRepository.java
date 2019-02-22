package br.com.home.repository;

import java.util.List;

import br.com.home.model.CotacaoResposta;
import br.com.home.utils.AbstractBase;

public class CotacaoRespostaRepository extends AbstractBase {

    public CotacaoResposta buscarPorId(final Integer idCotacaoResposta){
        CotacaoResposta cotacaoResposta = manager.find(CotacaoResposta.class, idCotacaoResposta);
        if (cotacaoResposta == null) {
            throw new RuntimeException("Cotacao Resposta " + idCotacaoResposta + " não encontrada!");
        }
        return cotacaoResposta;
    }

    public List<CotacaoResposta> buscarPorPropriedade(final String whereClause, final Object parametro) {
        return manager.createQuery("select c from CotacaoResposta c " + whereClause + parametro, CotacaoResposta.class)
                .getResultList();
    }

    public List<CotacaoResposta> buscarTodos() {
        return manager.createQuery("select c from CotacaoResposta c", CotacaoResposta.class).getResultList();
    }

    public Long quantidadeComPropriedade(final String whereClause, final Object parametro) {
        return (Long) manager
                .createQuery("select COUNT(c.idCotacaoResposta) from CotacaoResposta c " + whereClause + parametro)
                .getSingleResult();
    }

}
