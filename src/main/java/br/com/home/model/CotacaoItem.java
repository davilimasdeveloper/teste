//items da cotacao,id, id do produto , produto,quantidade,obeservacao,
package br.com.home.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cotacaoItem")
@SequenceGenerator(name = "COTACAOITEM_SEQ", sequenceName = "COTACAOITEM_SEQ", allocationSize = 1)
public class CotacaoItem {

    @Id
    @Column(name = "idCotacaoItem")
    @GeneratedValue(generator = "COTACAOITEM_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer idCotacaoItem;

    @Column(length = 80, nullable = false)
    private String descricao;

    @Column(length = 80, nullable = false)
    private String modelo;

    @Column(length = 1000, nullable = false)
    private BigDecimal quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idCotacao")
    private Cotacao cotacao;

    public CotacaoItem() {
    }

    public Integer getIdCotacaoItem() {
        return idCotacaoItem;
    }

    private void setIdCotacaoItem(final Integer idCotacaoItem) {
        this.idCotacaoItem = idCotacaoItem;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(final String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    private void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    private void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    private void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }

    public static class Builder {

        private Integer idCotacaoItem;
        private String descricao;
        private String modelo;
        private BigDecimal quantidade;
        private Cotacao cotacao;
        private Produto produto;

        public Builder() {

        }

        public Builder(final Cotacao cotacao) {
            this.cotacao = cotacao;
        }

        public Builder cotacao(final Cotacao cotacao) {
            this.cotacao = cotacao;
            return this;
        }

        public Builder idCotacaoItem(final Integer idCotacaoItem) {
            this.idCotacaoItem = idCotacaoItem;
            return this;
        }

        public Builder produto(final Produto produto) {
            this.produto = produto;
            return this;
        }

        public Builder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder modelo(final String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder quantidade(final BigDecimal quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public CotacaoItem build() {
            return new CotacaoItem(this);
        }

    }

    public CotacaoItem(final Builder builder) {
        this.setIdCotacaoItem(builder.idCotacaoItem);
        this.setProduto(builder.produto);
        this.setDescricao(builder.descricao);
        this.setModelo(builder.modelo);
        this.setQuantidade(builder.quantidade);
        this.setCotacao(builder.cotacao);
    }

}
