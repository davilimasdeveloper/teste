package br.com.home.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.home.model.Cotacao;
import br.com.home.model.CotacaoItem;
import br.com.home.service.CotacaoService;
import br.com.home.utils.MensagemResposta;
import br.com.home.repository.CotacaoRepository;
import br.com.home.repository.ProdutoRepository;
import br.com.home.resource.representation.CotacaoItemRepresentation;
import br.com.home.resource.representation.CotacaoRepresentation;
import br.com.home.service.CotacaoItemService;
import java.util.stream.Collectors;

@Path("cotacoes")
public class CotacaoResource {

    @Inject
    private CotacaoService service;
    @Inject
    private CotacaoItemService serviceItem;
    @Inject
    private CotacaoRepository repository;
    @Inject
    private ProdutoRepository repositoryProduto;
    @Inject
    private CotacaoRepresentation representation;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Cotacao cotacao) {
        try {
            final Cotacao atualizar = service.atualizar(cotacao);
            return Response.ok(representation.toRepresentation(atualizar)).status(Status.OK).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer idCotacao) {
        try {
            Cotacao cotacao = repository.buscarPorId(idCotacao);
            return Response.ok(representation.toRepresentation(cotacao)).build();
        } catch (Exception e) {
            MensagemResposta resultado = new MensagemResposta(e.getMessage());
            return Response.ok(resultado).status(200).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CotacaoRepresentation> buscarTodos() {
        return repository.buscarTodos().stream()
                .map(cot -> representation.toRepresentation(cot))
                .collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id) {
        try {
            service.deletar(id);
            return Response.ok("Cotacao removido com sucesso!").build();
        } catch (Exception e) {
            MensagemResposta resultado = new MensagemResposta(e.getMessage());
            return Response.ok(resultado).status(404).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(CotacaoRepresentation cotacao) {
        try {
            System.out.println(cotacao);
            Cotacao cotacaoPersist = new Cotacao.Builder()
                    .descricao(cotacao.getDescricao())
                    .responsavel(cotacao.getResponsavel())
                    .dataCotacao(cotacao.getDataCotacao()).build();

            cotacaoPersist = service.salvar(cotacaoPersist);

            for (CotacaoItemRepresentation item : cotacao.getItens()) {
                System.out.println("Item:" + item);
                CotacaoItem itemPersist = new CotacaoItem.Builder(cotacaoPersist)
                        .descricao(item.getDescricao())
                        .modelo(item.getModelo())
                        .quantidade(item.getQuantidade())
                        .produto(repositoryProduto.buscarPorId(item.getProduto().getIdProduto()))
                        .build();
                serviceItem.salvar(itemPersist);

            }

            final Cotacao buscarPorId = repository.buscarPorId(cotacaoPersist.getIdCotacao());

            return Response.ok(representation.toRepresentation(buscarPorId)).status(Status.CREATED).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
        }
    }

}
