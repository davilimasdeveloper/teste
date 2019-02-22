package br.com.home.resource.representation;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class GeraCotacaoRepresentation {

    private CotacaoRepresentation cotacaoRepresentation;
    private FornecedorRepresentation fornecedorRepresentation;

    public GeraCotacaoRepresentation() {
    }

    public CotacaoRepresentation getCotacaoRepresentation() {
        return cotacaoRepresentation;
    }

    public void setCotacaoRepresentation(CotacaoRepresentation cotacaoRepresentation) {
        this.cotacaoRepresentation = cotacaoRepresentation;
    }

    public FornecedorRepresentation getFornecedorRepresentation() {
        return fornecedorRepresentation;
    }

    public void setFornecedorRepresentation(FornecedorRepresentation fornecedorRepresetation) {
        this.fornecedorRepresentation = fornecedorRepresetation;
    }

}
