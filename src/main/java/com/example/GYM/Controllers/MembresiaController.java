package com.example.GYM.Controllers;

import com.example.GYM.DTOS.Requests.MembresiaRequest;
import com.example.GYM.DTOS.Response.MembresiaResponse;
import com.example.GYM.Services.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @PostMapping("/nueva")
    public ResponseEntity<MembresiaResponse> crearMembresia(@RequestBody MembresiaRequest membresiaRequest) {
        MembresiaResponse response = membresiaService.crearMembresia(membresiaRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MembresiaResponse>> listarMembresias() {
        List<MembresiaResponse> response = membresiaService.listarMembresias();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarMembresia(@PathVariable("id") Long id) {
        membresiaService.eliminarMembresia(id);
        return ResponseEntity.ok("Membresia eliminada correctamente");
    }
}
