package com.example.GYM.Controllers;

import com.example.GYM.DTOS.Requests.ProfesorRequest;
import com.example.GYM.Services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/nuevo")
    public ResponseEntity<String> nuevoProfesor(@RequestBody ProfesorRequest profesorRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.registrarProfesor(profesorRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarProfesor(@PathVariable("id") Long id) {
        try {
            profesorService.eliminarProfesor(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
