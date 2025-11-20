package com.javaspringatt.atividadebancodedados.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AttEnderecoModel {
    
    @Column(nullable = false)
    private String rua;
    
    @Column(nullable = false)
    private String numero;
    
    @Column
    private String complemento;
    
    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String cep;
    
    // construtores
    public AttEnderecoModel() {}
    
    public AttEnderecoModel(String rua, String numero, String bairro, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }
    
    // getters e setters
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}