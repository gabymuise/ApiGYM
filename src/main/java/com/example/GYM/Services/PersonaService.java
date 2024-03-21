package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.PersonaRequest;
import com.example.GYM.DTOS.Response.PersonasResponse;
import com.example.GYM.Mappers.PersonaMapper;
import com.example.GYM.Models.Persona;
import com.example.GYM.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    public ResponseEntity setPersona(PersonaRequest personaRequest) {
        Boolean existePersona = !findByDni(personaRequest.getDni()).isEmpty();
        if(!existePersona){
            Persona persona = personaMapper.personaRequestToPersona(personaRequest);
            personaRepository.save(persona);
            return ResponseEntity.ok("Persona guardada: " + persona.getNombre() + " " + persona.getApellido());
        } else {
            return ResponseEntity.badRequest().body("La persona con el DNI especificado ya existe.");
        }
    }

    public PersonasResponse listarPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return personaMapper.personaListToResponse(listaPersonas);
    }

    public List<Persona> findByDni(String dni) {
        return personaRepository.findByDni(dni);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
