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

import br.com.home.model.CotacaoItem;
import br.com.home.repository.CotacaoItemRepository;
import br.com.home.service.CotacaoItemService;
import br.com.home.utils.MensagemResposta;

@Path("cotacoes-itens")
public class CotacaoItemResource {

	@Inject
	private CotacaoItemService service;
	@Inject
	private CotacaoItemRepository repository;

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(CotacaoItem cotacaotaItem) {
		try {
			return Response.ok(service.atualizar(cotacaotaItem)).status(Status.OK).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") Integer idCotacaoItem) {
		try {
			CotacaoItem cotacaoItem = repository.buscarPorId(idCotacaoItem);
			return Response.ok(cotacaoItem).build();
		} catch (Exception e) {
			MensagemResposta resultado = new MensagemResposta(e.getMessage());
			return Response.ok(resultado).status(200).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CotacaoItem> buscarTodos() {
		return repository.buscarTodos();
	}

	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") Integer id) {
		try {
			service.deletar(id);
			return Response.ok("Cotacao  Item removido com sucesso!").build();
		} catch (Exception e) {
			MensagemResposta resultado = new MensagemResposta(e.getMessage());
			return Response.ok(resultado).status(404).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(CotacaoItem cotacaoItem) {
		try {
			return Response.ok(service.salvar(cotacaoItem)).status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.ok(new MensagemResposta(e.getMessage())).status(Status.BAD_REQUEST).build();
		}
	}

}
