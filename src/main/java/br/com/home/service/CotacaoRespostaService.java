package br.com.home.service;

import br.com.home.model.Cotacao;
import br.com.home.model.CotacaoItem;
import br.com.home.utils.AbstractBase;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.home.model.CotacaoResposta;
import br.com.home.model.CotacaoRespostaItem;
import br.com.home.repository.CotacaoRepository;
import br.com.home.repository.CotacaoRespostaRepository;
import br.com.home.resource.representation.FornecedorRepresentation;
import java.time.LocalDate;

@Stateless
public class CotacaoRespostaService extends AbstractBase {

    @Inject
    private CotacaoRespostaRepository repository;
    @Inject
    private CotacaoRespostaItemService serviceItem;
    @Inject
    private CotacaoRepository repositoryCotacao;

    public CotacaoResposta atualizar(final CotacaoResposta cotacaoResposta) {
        manager.merge(cotacaoResposta);
        return cotacaoResposta;
    }

    public void deletar(final Integer idCotacaoResposta) throws Exception {
        CotacaoResposta cotacaoResposta = repository.buscarPorId(idCotacaoResposta);
        if (cotacaoResposta != null) {
            manager.remove(cotacaoResposta);
        } else {
            throw new Exception("Cotacao de resposta  não encontrado!");
        }
    }

    public CotacaoResposta salvar(final CotacaoResposta cotacaoResposta) {
        manager.persist(cotacaoResposta);
        return cotacaoResposta;
    }

    public CotacaoResposta geraCotacaoResposta(final Cotacao cotacao, final FornecedorRepresentation fornecedor) throws Exception {

        CotacaoResposta resposta = new CotacaoResposta.Builder()
                .LocalDate(LocalDate.now())
                .cnpj(fornecedor.getCnpj())
                .idCotacao(cotacao.getIdCotacao())
                .email(fornecedor.getEmail())
                .endereco(fornecedor.getEmail())
                .nome(fornecedor.getNome())
                .telefone(fornecedor.getTelefone())
                .build();

        CotacaoResposta salvar = salvar(resposta);

        Cotacao buscarPorIdCotacao = repositoryCotacao.buscarPorId(cotacao.getIdCotacao());

        for (CotacaoItem item : buscarPorIdCotacao.getItens()) {
            CotacaoRespostaItem itemResposta = new CotacaoRespostaItem.Builder(item.getIdCotacaoItem())
                    .quantidade(item.getQuantidade())
                    .cotacao(resposta)
                    .build();
            serviceItem.salvar(itemResposta);
        }

        return repository.buscarPorId(salvar.getCotacaoResposta());
    }
}
