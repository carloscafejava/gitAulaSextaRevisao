package com.javaspringatt.atividadebancodedados.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringatt.atividadebancodedados.models.AttClienteModel;
import com.javaspringatt.atividadebancodedados.services.AttClienteService;

@RestController
@RequestMapping("/api/clientes")
public class AttClienteController {
    
    @Autowired
    private AttClienteService attClienteService;
    
    @GetMapping
    public ResponseEntity<List<AttClienteModel>> listarClientesAtivos() {
        List<AttClienteModel> clientes = attClienteService.listarClientesAtivos();
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AttClienteModel> buscarPorId(@PathVariable Long id) {
        try {
            AttClienteModel cliente = attClienteService.buscarPorId(id);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<AttClienteModel> buscarPorEmail(@PathVariable String email) {
        try {
            AttClienteModel cliente = attClienteService.buscarPorEmail(email);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<AttClienteModel> adicionarCliente(@RequestBody AttClienteModel cliente) {
        try {
            AttClienteModel novoCliente = attClienteService.adicionarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AttClienteModel> atualizarCliente(
            @PathVariable Long id,
            @RequestBody AttClienteModel clienteAtualizado) {
        try {
            AttClienteModel cliente = attClienteService.atualizarCliente(id, clienteAtualizado);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}