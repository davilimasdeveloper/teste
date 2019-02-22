package br.com.home.resource.representation;

import br.com.home.model.CotacaoItem;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class CotacaoItemRepresentation implements Serializable {
    
    @Inject
    private ProdutoRepresentation produtoRepresentation;
    
    private Integer idCotacaoItem;
    private String descricao;
    private String modelo;
    private BigDecimal quantidade;
    private ProdutoRepresentation produto;
    
    public CotacaoItemRepresentation() {
    }
    
    public Integer getIdCotacaoItem() {
        return idCotacaoItem;
    }
    
    private void setIdCotacaoItem(Integer idCotacaoItem) {
        this.idCotacaoItem = idCotacaoItem;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    
    private void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    
    public ProdutoRepresentation getProduto() {
        return produto;
    }
    
    private void setProduto(ProdutoRepresentation produto) {
        this.produto = produto;
    }
    
    public CotacaoItemRepresentation toRepresentation(final CotacaoItem cotacaoItem) {
        CotacaoItemRepresentation cotacaoItemRepresentation = new CotacaoItemRepresentation();
        cotacaoItemRepresentation.setDescricao(cotacaoItem.getDescricao());
        cotacaoItemRepresentation.setIdCotacaoItem(cotacaoItem.getIdCotacaoItem());
        cotacaoItemRepresentation.setModelo(cotacaoItem.getModelo());
        cotacaoItemRepresentation.setProduto(produtoRepresentation.toRepresentation(cotacaoItem.getProduto()));
        cotacaoItemRepresentation.setQuantidade(cotacaoItem.getQuantidade());
        
        return cotacaoItemRepresentation;
    }
    
    public List<CotacaoItemRepresentation> toRepresentation(final List<CotacaoItem> cotacaoItem) {
        return cotacaoItem.stream().map(cot -> toRepresentation(cot)).collect(Collectors.toList());
    }
    
    public CotacaoItem toEntity(final CotacaoItemRepresentation cotacaoItemRepresentation) {
        return new CotacaoItem.Builder()
                .descricao(cotacaoItemRepresentation.getDescricao())
                .idCotacaoItem(cotacaoItemRepresentation.getIdCotacaoItem())
                .modelo(cotacaoItemRepresentation.getModelo())
                .quantidade(cotacaoItemRepresentation.getQuantidade())
                .produto(produtoRepresentation.toEntity(cotacaoItemRepresentation.getProduto()))
                .build();
    }
    
    public List<CotacaoItem> toEntity(final List<CotacaoItemRepresentation> cotacaoItemRepresentation) {
        return cotacaoItemRepresentation.stream().map(cot -> toEntity(cot)).collect(Collectors.toList());
    }
    
}
