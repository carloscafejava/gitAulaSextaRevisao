package com.javaspringatt.atividadebancodedados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/")
public class AttBancoController {

@GetMapping
public ResponseEntity<AttBancoModel> listarTodos(){
    List<AttBancoModel> produtos = attService.listarTodos();
    return ResponseEntity.ok(produtos);
}
//tras algo do banco, busca informação através do ID
//@PathVariable - URL
//@RequestBody - página
@GetMapping("/{id}")
public ResponseEntity<AttBancoModel> buscarPorId(@PathVariable int id){
    AttBancoModel produto = attService.buscarPorId(id);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
}

@PostMapping
public ResponseEntity<AttBancoModel> adicionarProduto(@RequestBody AttBancoModel produto){
    AttBancoModel produtoSalvo = attService.adicionarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
}

@PutMapping("/{id}")
public ResponseEntity<> atualizarProduto(@PathVariable int id,  @RequestBody produto){
    AttBancoModel produtoAtualizado = attService.atualizarProduto(id, produto);
        if(produtoAtualizado != null){
            return ResponseEntity.notFound().build();
        }
@DeleteMapping("/{id}")
public ResponseEntity<void> deletarProduto(@PathVariable in id){
    AttBancoModel produto = attService.buscarPorId(id);
    if(produto != null){
        attService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
}
}




}
