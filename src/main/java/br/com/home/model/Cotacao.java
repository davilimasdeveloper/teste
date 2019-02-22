package br.com.home.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cotacao")
@SequenceGenerator(name = "COTACAO_SEQ", sequenceName = "COTACAO_SEQ", allocationSize = 1)
public class Cotacao {

    @Id
    @Column(name = "idCotacao")
    @GeneratedValue(generator = "COTACAO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer idCotacao;

    @Column(length = 80, nullable = false)
    private String descricao;

    @Column(length = 80, nullable = false)
    private String responsavel;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "dataCotacao")
    private LocalDate dataCotacao;

    @OneToMany(mappedBy = "cotacao", fetch = FetchType.EAGER)
    private List<CotacaoItem> itens;

    public Cotacao() {
    }

    public Integer getIdCotacao() {
        return idCotacao;
    }

    private void setIdCotacao(final Integer idCotacao) {
        this.idCotacao = idCotacao;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    private void setResponsavel(final String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataCotacao() {
        return dataCotacao;
    }

    private void setDataCotacao(final LocalDate dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public List<CotacaoItem> getItens() {
        return itens;
    }

    private void setItens(List<CotacaoItem> itens) {
        this.itens = itens;
    }

    public static class Builder {

        private Integer idCotacao;
        private String descricao;
        private String responsavel;
        private LocalDate dataCotacao;
        private List<CotacaoItem> itens;

        public Builder() {

        }

        public Builder idCotacao(final Integer idCotacao) {
            this.idCotacao = idCotacao;
            return this;
        }

        public Builder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder responsavel(final String responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public Builder dataCotacao(final LocalDate dataCotacao) {
            this.dataCotacao = dataCotacao;
            return this;
        }

        public Builder itens(final List<CotacaoItem> itens) {
            this.itens = itens;
            return this;
        }

        public Cotacao build() {
            return new Cotacao(this);
        }

    }

    public Cotacao(final Builder builder) {
        this.setIdCotacao(builder.idCotacao);
        this.setDescricao(builder.descricao);
        this.setResponsavel(builder.responsavel);
        this.setDataCotacao(builder.dataCotacao);
    }

}
