package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.ClienteRequest;
import com.example.GYM.Mappers.ClienteMapper;
import com.example.GYM.Models.Cliente;
import com.example.GYM.Models.Persona;
import com.example.GYM.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PersonaService personaService;

    public ResponseEntity setCliente(ClienteRequest clienteRequest) throws SQLException {
        Cliente cliente = new Cliente();
        setPersonaNuevaOExistente(clienteRequest, cliente);
        //profesor = profesorMapper.profesorRequestToProfesor(profesorRequest, profesor);

        try {
            clienteRepository.save(cliente);
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getCause().getLocalizedMessage());
        }
        return ResponseEntity.ok("Profesor guardado: " + cliente.getPersona().getNombre() + " "
                + cliente.getPersona().getApellido());
    }

    // Toma los datos de la persona de ProfesorRequest, verifica si existe la persona. Si no es así la crea
    // y si existe, toma esos datos y los asigna a profesor.
    public void setPersonaNuevaOExistente(ClienteRequest clienteRequest, Cliente cliente) {
        if (personaService.findByDni(clienteRequest.getPersona().getDni()).isEmpty()) {
            Persona persona = clienteMapper.clienteRequestToPersona(clienteRequest);
            cliente.setPersona(persona);
            personaService.save(persona);
        } else {
            cliente.setPersona(personaService.findByDni(clienteRequest.getPersona().getDni()).get(0));
        }
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}