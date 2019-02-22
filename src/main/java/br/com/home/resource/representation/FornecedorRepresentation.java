package br.com.home.resource.representation;

import java.math.BigDecimal;

public class FornecedorRepresentation {

    private BigDecimal cnpj;
    private BigDecimal telefone;
    private String email;
    private String endereco;
    private String nome;

    public FornecedorRepresentation() {
    }

    public BigDecimal getCnpj() {
        return cnpj;
    }

    public void setCnpj(BigDecimal cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getTelefone() {
        return telefone;
    }

    public void setTelefone(BigDecimal telefone) {
        this.telefone = telefone;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
