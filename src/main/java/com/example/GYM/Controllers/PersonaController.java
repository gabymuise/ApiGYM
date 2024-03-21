package com.example.GYM.Controllers;

import com.example.GYM.DTOS.Requests.PersonaRequest;
import com.example.GYM.DTOS.Response.PersonasResponse;
import com.example.GYM.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/personas")
@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/nuevaPersona")
    @ResponseBody
    public ResponseEntity nuevaPersona(@RequestBody PersonaRequest personaRequest) {
        return personaService.setPersona(personaRequest);
    }

    @GetMapping("/listarPersonas")
    @ResponseBody
    public PersonasResponse listarPersonas() {
        return personaService.listarPersonas();
    }

    @DeleteMapping("/borrarPersona/{id}")
    @ResponseBody
    public ResponseEntity borrarPersona(@PathVariable("id") Long id) throws SQLException {
        try {
            personaService.deletePersona(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. El error es: " + ex.getMessage());
        }
    }
}
