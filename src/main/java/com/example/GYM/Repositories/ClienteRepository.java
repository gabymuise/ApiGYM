package com.example.GYM.Repositories;

import com.example.GYM.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByApellido(String apellido);
}
