package br.com.home.service;

import br.com.home.utils.AbstractBase;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.home.model.Cotacao;
import br.com.home.repository.CotacaoRepository;

@Stateless
public class CotacaoService extends AbstractBase {

    @Inject
    private CotacaoRepository repository;

    public Cotacao atualizar(final Cotacao cotacao) {
        manager.merge(cotacao);
        return cotacao;
    }

    public void deletar(final Integer idCotacao) throws Exception {
        Cotacao cotacao = repository.buscarPorId(idCotacao);
        if (cotacao != null) {
            manager.remove(cotacao);
        } else {
            throw new Exception("Cotacao não encontrado!");
        }
    }

    public Cotacao salvar(final Cotacao cotacao) {
        manager.persist(cotacao);
        return cotacao;
    }

}
