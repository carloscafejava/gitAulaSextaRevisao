package com.javaspringatt.atividadebancodedados.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringatt.atividadebancodedados.models.AttClienteModel;
import com.javaspringatt.atividadebancodedados.repository.AttClienteRepository;

@Service
public class AttClienteService {

    @Autowired
    private AttClienteRepository clienteRepository;
    
    // Listar apenas clientes ativos
    public List<AttClienteModel> listarClientesAtivos() {
        return clienteRepository.findByAtivoTrue();
    }
    
    // Buscar cliente por ID
    public AttClienteModel buscarPorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }
    
    // Buscar cliente por e-mail
    public AttClienteModel buscarPorEmail(String email) {
        AttClienteModel cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado com email: " + email);
        }
        return cliente;
    }
    
    // Adicionar novo cliente
    public AttClienteModel adicionarCliente(AttClienteModel cliente) {
        // Campo pedidos inicia vazio
        cliente.setPedidos(null);
        // Cliente sempre inicia como ativo (já definido no @PrePersist)
        return clienteRepository.save(cliente);
    }
    
    // Atualizar informações do cliente
    public AttClienteModel atualizarCliente(Long id, AttClienteModel clienteAtualizado) {
        AttClienteModel cliente = buscarPorId(id);
        
        if (clienteAtualizado.getNomeCompleto() != null) {
            cliente.setNomeCompleto(clienteAtualizado.getNomeCompleto());
        }
        
        if (clienteAtualizado.getTelefone() != null) {
            cliente.setTelefone(clienteAtualizado.getTelefone());
        }
        
        if (clienteAtualizado.getEndereco() != null) {
            cliente.setEndereco(clienteAtualizado.getEndereco());
        }
        
        if (clienteAtualizado.getPreferencias() != null) {
            cliente.setPreferencias(clienteAtualizado.getPreferencias());
        }
        
        return clienteRepository.save(cliente);
    }
}

