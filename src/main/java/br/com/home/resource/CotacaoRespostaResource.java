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

import br.com.home.model.CotacaoResposta;
import br.com.home.repository.CotacaoRespostaRepository;
import br.com.home.resource.representation.CotacaoRepresentation;
import br.com.home.resource.representation.CotacaoRespostaItemRepresentation;
import br.com.home.resource.representation.CotacaoRespostaRepresentation;
import br.com.home.resource.representation.GeraCotacaoRepresentation;
import br.com.home.service.CotacaoRespostaItemService;
import br.com.home.service.CotacaoRespostaService;
import br.com.home.utils.MensagemResposta;
import java.util.stream.Collectors;

@Path("cotacoes-respostas")
public class CotacaoRespostaResource {

    @Inject
    private CotacaoRespostaService service;
    @Inject
    private CotacaoRespostaRepository repository;
    @Inject
    private CotacaoRespostaRepresentation representation;
    @Inject
    private CotacaoRepresentation representationCotacao;
    @Inject
    private CotacaoRespostaItemService serviceItem;
    @Inject
    private CotacaoRespostaItemRepresentation representationItem;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(CotacaoRespostaRepresentation cotacaoRepresentation) {
        try {
            final CotacaoResposta atualizar = service.atualizar(representation.toEntity(cotacaoRepresentation));
            return Response.ok(representation.toRepresentation(atualizar)).status(Status.OK).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer idCotacaoResposta) {
        try {
            CotacaoResposta cotacaoResposta = repository.buscarPorId(idCotacaoResposta);
            return Response.ok(representation.toRepresentation(cotacaoResposta)).build();
        } catch (Exception e) {
            MensagemResposta resultado = new MensagemResposta(e.getMessage());
            return Response.ok(resultado).status(200).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CotacaoRespostaRepresentation> buscarTodos() {
        return repository.buscarTodos().stream().map(m -> representation.toRepresentation(m)
        ).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id) {
        try {
            service.deletar(id);
            return Response.ok("Cotacao Resposta  removido com sucesso!").build();
        } catch (Exception e) {
            MensagemResposta resultado = new MensagemResposta(e.getMessage());
            return Response.ok(resultado).status(404).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(CotacaoRespostaRepresentation cotacaoRepresentation) {
        try {

            for (CotacaoRespostaItemRepresentation itens : cotacaoRepresentation.getItens()) {
                serviceItem.atualizar(representationItem.toEntity(itens));
            }

            CotacaoResposta buscarPorId = repository.buscarPorId(cotacaoRepresentation.getCotacaoResposta());

            return Response.ok(representation.toRepresentation(buscarPorId)).status(Status.CREATED).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("gera-resposta")
    public Response geraResposta(GeraCotacaoRepresentation cotacao) {
        try {
            final CotacaoResposta geraCotacaoResposta = service.geraCotacaoResposta(representationCotacao.toEntity(cotacao.getCotacaoRepresentation()), cotacao.getFornecedorRepresentation());
            return Response.ok(representation.toRepresentation(geraCotacaoResposta)).status(Status.CREATED).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage() + e.toString())).status(Status.BAD_REQUEST).build();
        }
    }

}
