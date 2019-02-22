package br.com.home.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
public class Produto {

    @Id
    @Column(name = "idProduto")
    @GeneratedValue(generator = "PRODUTO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer idProduto;

    @Column(length = 80, nullable = false)
    private String descricao;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 6, nullable = false)
    private BigDecimal preco;

    @Column(length = 1000, nullable = false)
    private BigDecimal quantidade;

    @Column(length = 3, nullable = false)
    private String tamanho;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "data")
    private LocalDate data;

    public Produto() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    private void setIdProduto(final Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(final String nome) {
        this.nome = nome;
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

    public String getTamanho() {
        return tamanho;
    }

    private void setTamanho(final String tamanho) {
        this.tamanho = tamanho;
    }

    public static class Builder {

        private Integer idProduto;
        private String descricao;
        private String nome;
        private BigDecimal preco;
        private BigDecimal quantidade;
        private String tamanho;
        private LocalDate data;

        public Builder() {

        }

        public Builder idProduto(final Integer idProduto) {
            this.idProduto = idProduto;
            return this;
        }

        public Builder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public Builder preco(final BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder quantidade(final BigDecimal quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Builder tamanho(final String tamanho) {
            this.tamanho = tamanho;
            return this;
        }

        public Builder data(final LocalDate data) {
            this.data = data;
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }

    }

    public Produto(final Builder builder) {
        this.setDescricao(builder.descricao);
        this.setIdProduto(builder.idProduto);
        this.setNome(builder.nome);
        this.setData(builder.data);
        this.setQuantidade(builder.quantidade);
        this.setTamanho(builder.tamanho);
        this.setPreco(builder.preco);

    }

}
