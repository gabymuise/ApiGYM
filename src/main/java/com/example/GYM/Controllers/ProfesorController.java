package com.example.GYM.Controllers;

import com.example.GYM.DTOS.Requests.ProfesorRequest;
import com.example.GYM.Services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/profesores")
@Controller
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/nuevoProfesor")
    @ResponseBody
    public ResponseEntity nuevoProfesor(@RequestBody ProfesorRequest profesorRequest) throws SQLException {
        return profesorService.setProfesor(profesorRequest);
    }

    @DeleteMapping("/borrarProfesor/{id}")
    @ResponseBody
    public ResponseEntity borrarProfesor(@PathVariable("id") Long id) throws SQLException {
        try {
            profesorService.deleteProfesor(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. El error es: " + ex.getMessage());
        }
    }
}
