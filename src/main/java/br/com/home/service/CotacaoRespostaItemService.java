package br.com.home.service;

import br.com.home.utils.AbstractBase;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.home.model.CotacaoRespostaItem;
import br.com.home.repository.CotacaoRespostaItemRepository;

@Stateless
public class CotacaoRespostaItemService extends AbstractBase {

    @Inject
    private CotacaoRespostaItemRepository repository;

    public CotacaoRespostaItem atualizar(final CotacaoRespostaItem cotacaoRespostaItem) {
        manager.merge(cotacaoRespostaItem);
        return cotacaoRespostaItem;
    }

    public void deletar(final Integer idCotacaoRespostaItem) throws Exception {
        CotacaoRespostaItem cotacaoRespostaItem = repository.buscarPorId(idCotacaoRespostaItem);
        if (cotacaoRespostaItem != null) {
            manager.remove(cotacaoRespostaItem);
        } else {
            throw new Exception("Cotacao de resposta  não encontrado!");
        }
    }

    public CotacaoRespostaItem salvar(final CotacaoRespostaItem cotacaoRespostaItem) {
        manager.persist(cotacaoRespostaItem);
        return cotacaoRespostaItem;
    }

}
