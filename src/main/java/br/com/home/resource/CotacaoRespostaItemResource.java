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

import br.com.home.model.CotacaoRespostaItem;
import br.com.home.repository.CotacaoRespostaItemRepository;
import br.com.home.resource.representation.CotacaoRespostaItemRepresentation;
import br.com.home.service.CotacaoRespostaItemService;
import br.com.home.utils.MensagemResposta;

@Path("cotacoes-respostas-itens")
public class CotacaoRespostaItemResource {

    @Inject
    private CotacaoRespostaItemService service;
    @Inject
    private CotacaoRespostaItemRepository repository;
    @Inject
    private CotacaoRespostaItemRepresentation representation;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(CotacaoRespostaItem cotacaoRespostaItem) {
        try {
            final CotacaoRespostaItem atualizar = service.atualizar(cotacaoRespostaItem);
            return Response.ok(representation.toRepresentation(atualizar)).status(Status.OK).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer idCotacaoRespostaItem) {
        try {
            CotacaoRespostaItem cotacaoRespostaItem = repository.buscarPorId(idCotacaoRespostaItem);
            return Response.ok(cotacaoRespostaItem).build();
        } catch (Exception e) {
            MensagemResposta resultado = new MensagemResposta(e.getMessage());
            return Response.ok(resultado).status(200).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CotacaoRespostaItem> buscarTodos() {
        return repository.buscarTodos();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id) {
        try {
            service.deletar(id);
            return Response.ok("Cotacao Resposta Item removido com sucesso!").build();
        } catch (Exception e) {
            MensagemResposta resultado = new MensagemResposta(e.getMessage());
            return Response.ok(resultado).status(404).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(CotacaoRespostaItem cotacaoRespostaItem) {
        try {
            return Response.ok(service.salvar(cotacaoRespostaItem)).status(Status.CREATED).build();
        } catch (Exception e) {
            return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
        }
    }

}
