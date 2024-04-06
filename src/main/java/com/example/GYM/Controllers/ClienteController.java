package com.example.GYM.Controllers;

import com.example.GYM.DTOS.Requests.ClienteRequest;
import com.example.GYM.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/nuevo")
    public ResponseEntity<String> nuevoCliente(@RequestBody ClienteRequest clienteRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.registrarCliente(clienteRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarCliente(@PathVariable("id") Long id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
