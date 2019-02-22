//dados do fornecedor : nome,email,telefone,cnpj,edereco,data da resposta 
package br.com.home.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "cotacao_resposta")
@SequenceGenerator(name = "COTACAO_RESPOSTA_SEQ", sequenceName = "COTACAO_RESPOSTA_SEQ", allocationSize = 1)
public class CotacaoResposta {

    @Id
    @Column(name = "cotacao_resposta")
    @GeneratedValue(generator = "COTACAO_RESPOSTA_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer cotacaoResposta;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 80, nullable = false)
    private String email;

    @Column(length = 80, nullable = false)
    private String endereco;

    @Column(length = 12, nullable = false)
    private BigDecimal telefone;

    @Column(length = 25, nullable = false)
    private BigDecimal cnpj;

    @Column(name = "data_resposta")
    private LocalDate dataResposta;

    @OneToMany(mappedBy = "cotacaoResposta", fetch = FetchType.EAGER)
    private List<CotacaoRespostaItem> itens;

    @Column(name = "idCotacao")
    private Integer idCotacao;

    public Integer getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Integer idCotacao) {
        this.idCotacao = idCotacao;
    }

    public List<CotacaoRespostaItem> getItens() {
        return itens;
    }

    public void setItens(List<CotacaoRespostaItem> itens) {
        this.itens = itens;
    }

    public CotacaoResposta() {
    }

    public Integer getCotacaoResposta() {
        return cotacaoResposta;
    }

    public void setCotacaoResposta(Integer cotacaoResposta) {
        this.cotacaoResposta = cotacaoResposta;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(final String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(final String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getTelefone() {
        return telefone;
    }

    private void setTelefone(final BigDecimal telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getCnpj() {
        return cnpj;
    }

    private void setCnpj(final BigDecimal cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDate dataResposta) {
        this.dataResposta = dataResposta;
    }

    private void setIdCotacaoResposta(Integer idCotacaoResposta) {
        this.cotacaoResposta = idCotacaoResposta;
    }

    public static class Builder {

        private Integer idCotacaoResposta;
        private String nome;
        private String email;
        private String endereco;
        private BigDecimal telefone;
        private BigDecimal cnpj;
        private LocalDate dataResposta;
        private Integer idCotacao;
        private List<CotacaoRespostaItem> itens;

        public Builder() {

        }

        public Builder idCotacaoresposta(final Integer idCotacaoresposta) {
            this.idCotacaoResposta = idCotacaoresposta;
            return this;
        }

        public Builder idCotacao(final Integer idCotacao) {
            this.idCotacao = idCotacao;
            return this;
        }

        public Builder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder endereco(final String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder cnpj(final BigDecimal cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder telefone(final BigDecimal telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder LocalDate(final LocalDate dataResposta) {
            this.dataResposta = dataResposta;
            return this;
        }

        public CotacaoResposta build() {
            return new CotacaoResposta(this);
        }

        public CotacaoResposta.Builder itens(final List<CotacaoRespostaItem> itens) {
            this.itens = itens;
            return this;
        }

    }

    public CotacaoResposta(final Builder builder) {
        this.setIdCotacaoResposta(builder.idCotacaoResposta);
        this.setIdCotacao(builder.idCotacao);
        this.setNome(builder.nome);
        this.setEmail(builder.email);
        this.setEndereco(builder.endereco);
        this.setTelefone(builder.telefone);
        this.setCnpj(builder.cnpj);
        this.setDataResposta(builder.dataResposta);

    }

}
