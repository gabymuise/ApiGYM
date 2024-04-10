package com.example.GYM.Controllers;

import com.example.GYM.DTOS.Requests.PersonaRequest;
import com.example.GYM.DTOS.Response.PersonasResponse;
import com.example.GYM.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;
/*
    @PostMapping("/nueva")
    public ResponseEntity<String> nuevaPersona(@RequestBody PersonaRequest personaRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(personaService.registrarPersona(personaRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/

    @GetMapping("/listar")
    public ResponseEntity<PersonasResponse> listarPersonas() {
        return ResponseEntity.ok(personaService.listarPersonas());
    }
/*
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarPersona(@PathVariable("id") Long id) {
        try {
            personaService.eliminarPersona(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
