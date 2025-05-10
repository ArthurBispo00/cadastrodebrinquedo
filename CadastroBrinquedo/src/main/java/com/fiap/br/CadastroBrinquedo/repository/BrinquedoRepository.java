// com/fiap/br/repository/BrinquedoRepository.java
package com.fiap.br.CadastroBrinquedo.repository;

import com.fiap.br.CadastroBrinquedo.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
    // Consultas personalizadas podem ser adicionadas aqui, se necessário
}
