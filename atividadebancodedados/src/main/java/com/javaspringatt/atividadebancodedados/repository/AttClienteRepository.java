package com.javaspringatt.atividadebancodedados.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspringatt.atividadebancodedados.models.AttClienteModel;

public interface AttClienteRepository extends JpaRepository<AttClienteModel, Long> {
    AttClienteModel findByEmail(String email);
    List<AttClienteModel> findByAtivoTrue();
}