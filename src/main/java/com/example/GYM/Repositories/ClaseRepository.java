package com.example.GYM.Repositories;

import com.example.GYM.Models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    List<Clase> findByNombre(String nombre);
}