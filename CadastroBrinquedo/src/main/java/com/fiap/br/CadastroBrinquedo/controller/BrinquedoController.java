package com.fiap.br.CadastroBrinquedo.controller;

import com.fiap.br.CadastroBrinquedo.model.Brinquedo;
import com.fiap.br.CadastroBrinquedo.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brinquedos")  // Define o caminho base para os endpoints
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    // 1. Listar todos os brinquedos
    @GetMapping
    public List<Brinquedo> listarBrinquedos() {
        return brinquedoRepository.findAll();  // Retorna todos os brinquedos
    }

    // 2. Buscar um brinquedo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarBrinquedo(@PathVariable Long id) {
        Optional<Brinquedo> brinquedo = brinquedoRepository.findById(id);
        if (brinquedo.isPresent()) {
            return ResponseEntity.ok(brinquedo.get());  // Retorna o brinquedo encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna erro 404 caso não encontrado
        }
    }

    // 3. Criar um novo brinquedo
    @PostMapping
    public ResponseEntity<Brinquedo> criarBrinquedo(@RequestBody Brinquedo brinquedo) {
        Brinquedo novoBrinquedo = brinquedoRepository.save(brinquedo);  // Salva o novo brinquedo no banco
        return ResponseEntity.status(201).body(novoBrinquedo);  // Retorna o brinquedo criado com status 201
    }

    // 4. Atualizar um brinquedo existente
    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizarBrinquedo(@PathVariable Long id, @RequestBody Brinquedo brinquedoAtualizado) {
        Optional<Brinquedo> brinquedoExistente = brinquedoRepository.findById(id);
        if (brinquedoExistente.isPresent()) {
            brinquedoAtualizado.setId(id);  // Garante que o ID não será alterado
            Brinquedo brinquedoSalvo = brinquedoRepository.save(brinquedoAtualizado);  // Atualiza o brinquedo
            return ResponseEntity.ok(brinquedoSalvo);  // Retorna o brinquedo atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna erro 404 se não encontrar o brinquedo
        }
    }

    // 5. Deletar um brinquedo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBrinquedo(@PathVariable Long id) {
        Optional<Brinquedo> brinquedo = brinquedoRepository.findById(id);
        if (brinquedo.isPresent()) {
            brinquedoRepository.delete(brinquedo.get());  // Deleta o brinquedo
            return ResponseEntity.noContent().build();  // Retorna status 204 (sem conteúdo)
        } else {
            return ResponseEntity.notFound().build();  // Retorna erro 404 caso não encontre o brinquedo
        }
    }
}
