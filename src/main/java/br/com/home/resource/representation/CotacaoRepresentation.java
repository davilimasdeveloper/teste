package br.com.home.resource.representation;

import br.com.home.model.Cotacao;
import br.com.home.model.CotacaoRespostaItem;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class CotacaoRepresentation implements Serializable {

    @Inject
    private CotacaoItemRepresentation cotacaoItemRepresentation;

    private Integer idCotacao;
    private String descricao;
    private String responsavel;
    private LocalDate dataCotacao;
    private List<CotacaoItemRepresentation> itens;

    public CotacaoRepresentation() {
    }

    public Integer getIdCotacao() {
        return idCotacao;
    }

    private void setIdCotacao(Integer idCotacao) {
        this.idCotacao = idCotacao;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    private void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataCotacao() {
        return dataCotacao;
    }

    private void setDataCotacao(LocalDate dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public List<CotacaoItemRepresentation> getItens() {
        return itens;
    }

    private void setItens(List<CotacaoItemRepresentation> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CotacaoRepresentation{" + "idCotacao=" + idCotacao + ", descricao=" + descricao + ", responsavel=" + responsavel + ", dataCotacao=" + dataCotacao + ", itens=" + itens + '}';
    }

    public CotacaoRepresentation toRepresentation(final Cotacao cotacao) {
        CotacaoRepresentation cotacaoRepresentation = new CotacaoRepresentation();
        cotacaoRepresentation.setDataCotacao(cotacao.getDataCotacao());
        cotacaoRepresentation.setDescricao(cotacao.getDescricao());
        cotacaoRepresentation.setIdCotacao(cotacao.getIdCotacao());
        cotacaoRepresentation.setResponsavel(cotacao.getResponsavel());
        cotacaoRepresentation.setItens(cotacaoItemRepresentation.toRepresentation(cotacao.getItens()));
        return cotacaoRepresentation;
    }

    public Cotacao toEntity(final CotacaoRepresentation cotacaoReprentation) {
        return new Cotacao.Builder()
                .dataCotacao(cotacaoReprentation.getDataCotacao())
                .descricao(cotacaoReprentation.getDescricao())
                .responsavel(cotacaoReprentation.getResponsavel())
                .idCotacao(cotacaoReprentation.getIdCotacao())
                .itens(cotacaoItemRepresentation.toEntity(cotacaoReprentation.getItens()))
                .build();
    }

}
