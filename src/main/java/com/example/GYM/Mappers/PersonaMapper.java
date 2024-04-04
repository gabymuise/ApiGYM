package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.PersonaRequest;
import com.example.GYM.DTOS.Response.PersonaResponse;
import com.example.GYM.DTOS.Response.PersonasResponse;
import com.example.GYM.Models.Persona;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonaMapper {

    public PersonaResponse toPersonaResponse(Persona persona) {
        PersonaResponse response = new PersonaResponse();
        response.setNombre(persona.getNombre());
        response.setApellido(persona.getApellido());
        response.setDni(persona.getDni());
        response.setTelefono(persona.getTelefono());
        response.setMail(persona.getMail());
        response.setDireccion(persona.getDireccion());
        return response;
    }

    public PersonasResponse toPersonasResponse(List<Persona> personas) {
        PersonasResponse response = new PersonasResponse();
        response.setPersonas(personas.stream().map(this::toPersonaResponse).collect(Collectors.toList()));
        return response;
    }

    public Persona toPersona(PersonaRequest request) {
        Persona persona = new Persona();
        persona.setNombre(request.getNombre());
        persona.setApellido(request.getApellido());
        persona.setDni(request.getDni());
        persona.setTelefono(request.getTelefono());
        persona.setMail(request.getMail());
        persona.setDireccion(request.getDireccion());
        return persona;
    }
}
