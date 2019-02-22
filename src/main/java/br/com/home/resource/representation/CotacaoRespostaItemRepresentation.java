package br.com.home.resource.representation;

import br.com.home.model.CotacaoRespostaItem;
import br.com.home.repository.CotacaoItemRepository;
import br.com.home.repository.CotacaoRespostaRepository;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class CotacaoRespostaItemRepresentation implements Serializable {

    @Inject
    private CotacaoRespostaRepository cotacaoRespostaRepository;
    @Inject
    private CotacaoItemRepository cotacaoItemRepository;
    @Inject
    private CotacaoItemRepresentation cotacaoItemRepresentation;

    private Integer idCotacaoRespostaItem;
    private String marca;
    private String modelo;
    private BigDecimal preco;
    private BigDecimal quantidade;
    private String disponivel;
    private CotacaoItemRepresentation cotacaoItem;
    private Integer idCotacaoResposta;

    public Integer getIdCotacaoRespostaItem() {
        return idCotacaoRespostaItem;
    }

    public void setIdCotacaoRespostaItem(Integer idCotacaoRespostaItem) {
        this.idCotacaoRespostaItem = idCotacaoRespostaItem;
    }

    public Integer getIdCotacaoResposta() {
        return idCotacaoResposta;
    }

    public void setIdCotacaoResposta(Integer idCotacaoResposta) {
        this.idCotacaoResposta = idCotacaoResposta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public CotacaoItemRepresentation getCotacaoItem() {
        return cotacaoItem;
    }

    public void setCotacaoItem(CotacaoItemRepresentation cotacaoItem) {
        this.cotacaoItem = cotacaoItem;
    }

    public CotacaoRespostaItemRepresentation toRepresentation(final CotacaoRespostaItem cotacaoRespostaItem) {
        CotacaoRespostaItemRepresentation cotacaoItemRespostaRepresentation = new CotacaoRespostaItemRepresentation();
        cotacaoItemRespostaRepresentation.setDisponivel(cotacaoRespostaItem.getDisponivel());
        cotacaoItemRespostaRepresentation.setMarca(cotacaoRespostaItem.getMarca());
        cotacaoItemRespostaRepresentation.setPreco(cotacaoRespostaItem.getPreco());
        cotacaoItemRespostaRepresentation.setIdCotacaoRespostaItem(cotacaoRespostaItem.getIdCotacaoRespostaItem());
        cotacaoItemRespostaRepresentation.setModelo(cotacaoRespostaItem.getModelo());
        cotacaoItemRespostaRepresentation.setQuantidade(cotacaoRespostaItem.getQuantidade());
        cotacaoItemRespostaRepresentation.setIdCotacaoResposta(cotacaoRespostaItem.getCotacaoResposta().getCotacaoResposta());

        try {
            cotacaoItemRespostaRepresentation.setCotacaoItem(cotacaoItemRepresentation.toRepresentation(cotacaoItemRepository.buscarPorId(cotacaoRespostaItem.getIdCotacaoItem())));
        } catch (Exception e) {
            System.out.println("Verificar problema:" + e.getMessage());
        }

        return cotacaoItemRespostaRepresentation;

    }

    public List<CotacaoRespostaItemRepresentation> toRepresentation(final List<CotacaoRespostaItem> cotacaoRespostaItem) {
        return cotacaoRespostaItem.stream().map(cot -> toRepresentation(cot)).collect(Collectors.toList());
    }

    public CotacaoRespostaItem toEntity(final CotacaoRespostaItemRepresentation cotacaoItemRepresentation) {
        return new CotacaoRespostaItem.Builder()
                .disponivel(cotacaoItemRepresentation.getDisponivel())
                .idCotacaoRespostaItem(cotacaoItemRepresentation.getIdCotacaoRespostaItem())
                .marca(cotacaoItemRepresentation.getMarca())
                .preco(cotacaoItemRepresentation.getPreco())
                .modelo(cotacaoItemRepresentation.getModelo())
                .quantidade(cotacaoItemRepresentation.getQuantidade())
                .idCotacaoItem(cotacaoItemRepresentation.getCotacaoItem().getIdCotacaoItem())
                .cotacao(cotacaoRespostaRepository.buscarPorId(cotacaoItemRepresentation.getIdCotacaoResposta()))
                .build();

    }

    public List<CotacaoRespostaItem> toEntity(final List<CotacaoRespostaItemRepresentation> cotacaoRespostaItemRepresentation) {
        return cotacaoRespostaItemRepresentation.stream().map(cot -> toEntity(cot)).collect(Collectors.toList());
    }

}
