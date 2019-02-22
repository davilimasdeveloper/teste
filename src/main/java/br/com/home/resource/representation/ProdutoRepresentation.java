package br.com.home.resource.representation;

import br.com.home.model.Produto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class ProdutoRepresentation implements Serializable {
    
    private Integer idProduto;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private BigDecimal quantidade;
    private String tamanho;
    
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate data;
    
    public ProdutoRepresentation() {
    }
    
    public Integer getIdProduto() {
        return idProduto;
    }
    
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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
    
    public String getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "ProdutoRepresentation{" + "idProduto=" + idProduto + ", descricao=" + descricao + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + ", tamanho=" + tamanho + ", data=" + data + '}';
    }
    
    public ProdutoRepresentation toRepresentation(final Produto produto) {
        ProdutoRepresentation produtoRepresentation = new ProdutoRepresentation();
        produtoRepresentation.setData(produto.getData());
        produtoRepresentation.setDescricao(produto.getDescricao());
        produtoRepresentation.setIdProduto(produto.getIdProduto());
        produtoRepresentation.setNome(produto.getNome());
        produtoRepresentation.setPreco(produto.getPreco());
        produtoRepresentation.setQuantidade(produto.getQuantidade());
        produtoRepresentation.setTamanho(produto.getTamanho());
        return produtoRepresentation;
    }
    
    public Produto toEntity(final ProdutoRepresentation produtoRepresentation) {
        return new Produto.Builder()
                .data(produtoRepresentation.getData())
                .descricao(produtoRepresentation.getDescricao())
                .idProduto(produtoRepresentation.getIdProduto())
                .nome(produtoRepresentation.getNome())
                .preco(produtoRepresentation.getPreco())
                .quantidade(produtoRepresentation.getQuantidade())
                .tamanho(produtoRepresentation.getTamanho())
                .build();
    }
    
}
