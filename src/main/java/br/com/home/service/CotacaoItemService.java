package br.com.home.service;

import br.com.home.utils.AbstractBase;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.home.model.CotacaoItem;
import br.com.home.repository.CotacaoItemRepository;

@Stateless
public class CotacaoItemService extends AbstractBase {

    @Inject
    private CotacaoItemRepository repository;

    public CotacaoItem atualizar(final CotacaoItem cotacaoItem) {
        manager.merge(cotacaoItem);
        return cotacaoItem;
    }

    public void deletar(final Integer idCotacaoItem) throws Exception {
        CotacaoItem cotacaoItem = repository.buscarPorId(idCotacaoItem);
        if (cotacaoItem != null) {
            manager.remove(cotacaoItem);
        } else {
            throw new Exception("Cotacao de items não encontrado!");
        }
    }

    public CotacaoItem salvar(final CotacaoItem cotacaoItem) {
        manager.persist(cotacaoItem);
        return cotacaoItem;
    }

}
