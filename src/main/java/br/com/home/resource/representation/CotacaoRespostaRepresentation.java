package br.com.home.resource.representation;

import br.com.home.model.CotacaoResposta;
import br.com.home.repository.CotacaoRepository;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class CotacaoRespostaRepresentation implements Serializable {

    @Inject
    private CotacaoRespostaItemRepresentation cotacaoRespostaItemRepresentation;
    @Inject
    private CotacaoRepresentation cotacaoRepresentation;

    private Integer cotacaoResposta;
    private String nome;
    private String email;
    private String endereco;
    private BigDecimal telefone;
    private BigDecimal cnpj;
    private LocalDate dataResposta;
    private List<CotacaoRespostaItemRepresentation> itens;
    private CotacaoRepresentation cotacao;

    public CotacaoRespostaRepresentation() {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getTelefone() {
        return telefone;
    }

    public void setTelefone(BigDecimal telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getCnpj() {
        return cnpj;
    }

    public void setCnpj(BigDecimal cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDate dataResposta) {
        this.dataResposta = dataResposta;
    }

    public List<CotacaoRespostaItemRepresentation> getItens() {
        return itens;
    }

    public void setItens(List<CotacaoRespostaItemRepresentation> itens) {
        this.itens = itens;
    }

    public CotacaoRepresentation getCotacao() {
        return cotacao;
    }

    public void setCotacao(CotacaoRepresentation cotacao) {
        this.cotacao = cotacao;
    }

    @Inject
    private CotacaoRepository repository;

    public CotacaoRespostaRepresentation toRepresentation(final CotacaoResposta cotacaoResposta) {
        CotacaoRespostaRepresentation cotacaoRespostaRepresentation = new CotacaoRespostaRepresentation();
        cotacaoRespostaRepresentation.setDataResposta(cotacaoResposta.getDataResposta());
        cotacaoRespostaRepresentation.setEmail(cotacaoResposta.getEmail());
        cotacaoRespostaRepresentation.setNome(cotacaoResposta.getNome());
        cotacaoRespostaRepresentation.setCnpj(cotacaoResposta.getCnpj());
        cotacaoRespostaRepresentation.setEndereco(cotacaoResposta.getEndereco());
        cotacaoRespostaRepresentation.setTelefone(cotacaoResposta.getTelefone());
        cotacaoRespostaRepresentation.setCotacaoResposta(cotacaoResposta.getCotacaoResposta());
        cotacaoRespostaRepresentation.setItens(cotacaoRespostaItemRepresentation.toRepresentation(cotacaoResposta.getItens()));
        cotacaoRespostaRepresentation.setCotacao(cotacaoRepresentation.toRepresentation(repository.buscarPorId(cotacaoResposta.getIdCotacao())));

        return cotacaoRespostaRepresentation;
    }

    public CotacaoResposta toEntity(final CotacaoRespostaRepresentation cotacaoRespostaReprentation) {
        return new CotacaoResposta.Builder()
                .email(cotacaoRespostaReprentation.getEmail())
                .nome(cotacaoRespostaReprentation.getNome())
                .cnpj(cotacaoRespostaReprentation.getCnpj())
                .endereco(cotacaoRespostaReprentation.getEndereco())
                .telefone(cotacaoRespostaReprentation.getTelefone())
                .itens(cotacaoRespostaItemRepresentation.toEntity(cotacaoRespostaReprentation.getItens()))
                .idCotacao(cotacaoRepresentation.toEntity(cotacaoRespostaReprentation.getCotacao()).getIdCotacao())
                .build();
    }
}
