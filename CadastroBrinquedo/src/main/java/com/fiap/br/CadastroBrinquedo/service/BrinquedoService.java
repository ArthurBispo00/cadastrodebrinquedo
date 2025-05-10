package com.fiap.br.CadastroBrinquedo.service;

import com.fiap.br.CadastroBrinquedo.model.Brinquedo;
import com.fiap.br.CadastroBrinquedo.repository.BrinquedoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrinquedoService {

    private final BrinquedoRepository repository;

    public BrinquedoService(BrinquedoRepository repository) {
        this.repository = repository;
    }

    public Brinquedo salvar(Brinquedo brinquedo) {
        return repository.save(brinquedo);
    }

    public List<Brinquedo> listarTodos() {
        return repository.findAll();
    }
}
