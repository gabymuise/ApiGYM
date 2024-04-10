package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.PersonaRequest;
import com.example.GYM.DTOS.Response.PersonasResponse;
import com.example.GYM.Mappers.PersonaMapper;
import com.example.GYM.Models.Persona;
import com.example.GYM.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;


    public String registrarPersona(PersonaRequest personaRequest) {
        if (personaRepository.findByDni(personaRequest.getDni()).isEmpty()){
            throw new IllegalArgumentException("La persona con el DNI especificado ya existe.");
        }
        Persona persona = personaMapper.toPersona(personaRequest);
        personaRepository.save(persona);
        return "Persona guardada: " + persona.getNombre() + " " + persona.getApellido();
    }

    public PersonasResponse listarPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personaMapper.toPersonasResponse(personas);
    }


    public void eliminarPersona(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new IllegalArgumentException("No se pudo encontrar la persona con el ID especificado.");
        }
        personaRepository.deleteById(id);
    }
}
