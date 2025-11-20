package com.javaspringatt.atividadebancodedados.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class AttClienteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nomeCompleto;
    
    @Column(nullable = false)
    private String email;
    
    @Column
    private String telefone;
    
    @Embedded
    private AttEnderecoModel endereco;
    
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
    
    @Column(nullable = false)
    private Boolean ativo = true;
    
    @Column(columnDefinition = "TEXT")
    private String preferencias;
    
    @Column(columnDefinition = "TEXT")
    private String historicCompras;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(columnDefinition = "TEXT")
    private String pedidos;
    
    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
        ativo = true;
    }
    
    // // getters e setters
    // public Long getId() { return id; }
    // public void setId(Long id) { this.id = id; }
    
    // public String getNomeCompleto() { return nomeCompleto; }
    // public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    
    // public String getEmail() { return email; }
    // public void setEmail(String email) { this.email = email; }
    
    // public String getTelefone() { return telefone; }
    // public void setTelefone(String telefone) { this.telefone = telefone; }
    
    // public AttEnderecoModel getEndereco() { return endereco; }
    // public void setEndereco(AttEnderecoModel endereco) { this.endereco = endereco; }
    
    // public LocalDateTime getDataCadastro() { return dataCadastro; }
    // public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    
    // public Boolean getAtivo() { return ativo; }
    // public void setAtivo(Boolean ativo) { this.ativo = ativo; }
    
    // public String getPreferencias() { return preferencias; }
    // public void setPreferencias(String preferencias) { this.preferencias = preferencias; }
    
    // public String getHistoricCompras() { return historicCompras; }
    // public void setHistoricCompras(String historicCompras) { this.historicCompras = historicCompras; }
    
    // public String getCpf() { return cpf; }
    // public void setCpf(String cpf) { this.cpf = cpf; }
    
    // public String getPedidos() { return pedidos; }
    // public void setPedidos(String pedidos) { this.pedidos = pedidos; }
}