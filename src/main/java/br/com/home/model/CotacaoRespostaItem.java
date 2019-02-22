//dados referentes a respostas dos fornecedores ex:marca,preco,quantidade desponivel.,
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
@Table(name = "cotacaoRespostaItem")
@SequenceGenerator(name = "COTACAOITEM_SEQ", sequenceName = "COTACAOITEM_SEQ", allocationSize = 1)
public class CotacaoRespostaItem {

    @Id
    @Column(name = "idCotacaoRespostaItem")
    @GeneratedValue(generator = "COTACAOITEM_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer idCotacaoRespostaItem;

    @Column(length = 80)
    private String marca;

    @Column(length = 80)
    private String modelo;

    @Column(length = 10)
    private BigDecimal preco;

    @Column(length = 1000)
    private BigDecimal quantidade;

    @Column(length = 3)
    private String disponivel;

    @ManyToOne
    @JoinColumn(name = "idCotacaoResposta")
    private CotacaoResposta cotacaoResposta;

    @Column(name = "idCotacaoItem")
    private Integer idCotacaoItem;

    public CotacaoRespostaItem() {
    }

    public Integer getIdCotacaoRespostaItem() {
        return idCotacaoRespostaItem;
    }

    public void setIdCotacaoRespostaItem(Integer idCotacaoRespostaItem) {
        this.idCotacaoRespostaItem = idCotacaoRespostaItem;
    }

    public CotacaoResposta getCotacaoResposta() {
        return cotacaoResposta;
    }

    public void setCotacaoResposta(CotacaoResposta cotacaoResposta) {
        this.cotacaoResposta = cotacaoResposta;
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(final String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(final String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    private void setPreco(final BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    private void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getDisponivel() {
        return disponivel;
    }

    private void setDisponivel(final String disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getIdCotacaoItem() {
        return idCotacaoItem;
    }

    private void setIdCotacaoItem(final Integer idCotacaoItem) {
        this.idCotacaoItem = idCotacaoItem;
    }

    public static class Builder {

        private Integer idCotacaoRespostaItem;
        private String marca;
        private String modelo;
        private BigDecimal preco;
        private BigDecimal quantidade;
        private String disponivel;
        private CotacaoResposta cotacaoResposta;
        private Integer idCotacaoItem;

        public Builder() {

        }

        public Builder(final Integer idCotacaoItem) {
            this.idCotacaoItem = idCotacaoItem;
        }

        public Builder(final CotacaoResposta cotacaoResposta) {
            this.cotacaoResposta = cotacaoResposta;
        }

        public Builder cotacao(final CotacaoResposta cotacaoResposta) {
            this.cotacaoResposta = cotacaoResposta;
            return this;
        }

        public Builder idCotacaoRespostaItem(final Integer idCotacaoRespostaItem) {
            this.idCotacaoRespostaItem = idCotacaoRespostaItem;
            return this;
        }

        public Builder marca(final String marca) {
            this.marca = marca;
            return this;
        }

        public Builder modelo(final String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder preco(final BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder disponivel(final String disponivel) {
            this.disponivel = disponivel;
            return this;
        }

        public Builder quantidade(BigDecimal quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Builder idCotacaoItem(Integer idCotacaoItem) {
            this.idCotacaoItem = idCotacaoItem;
            return this;
        }

        public CotacaoRespostaItem build() {
            return new CotacaoRespostaItem(this);
        }

    }

    public CotacaoRespostaItem(final Builder builder) {
        this.setIdCotacaoRespostaItem(builder.idCotacaoRespostaItem);
        this.setIdCotacaoItem(builder.idCotacaoItem);
        this.setCotacaoResposta(builder.cotacaoResposta);
        this.setDisponivel(builder.disponivel);
        this.setMarca(builder.marca);
        this.setModelo(builder.modelo);
        this.setPreco(builder.preco);
        this.setQuantidade(builder.quantidade);
    }

}
