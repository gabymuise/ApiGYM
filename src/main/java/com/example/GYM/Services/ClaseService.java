package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.ClaseRequest;
import com.example.GYM.Models.Clase;
import com.example.GYM.Repositories.ClaseRepository;
import com.example.GYM.Mappers.ClaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private ClaseMapper claseMapper;

    public ResponseEntity<?> crearNuevaClase(ClaseRequest claseRequest) {
        Boolean existeClase = !findByNombre(claseRequest.getNombre()).isEmpty();
        if (!existeClase) {
            Clase clase = claseMapper.claseRequestToClase(claseRequest);
            claseRepository.save(clase);
            return ResponseEntity.ok("Clase guardada: " + clase.getNombre());
        } else {
            return ResponseEntity.badRequest().body("La clase con el nombre especificado ya existe.");
        }
    }

    public ResponseEntity<?> actualizarClaseExistente(ClaseRequest claseRequest, Clase claseExistente) {
        claseMapper.actualizarClaseDesdeRequest(claseRequest, claseExistente);
        claseRepository.save(claseExistente);
        return ResponseEntity.ok("Clase actualizada: " + claseExistente.getNombre());
    }

    public List<Clase> findByNombre(String nombre) {
        return claseRepository.findByNombre(nombre);
    }

    public Clase save(Clase clase) {
        return claseRepository.save(clase);
    }

    public void deleteClase(Long id) {
        claseRepository.deleteById(id);
    }
}
