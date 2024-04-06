package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.ProfesorRequest;
import com.example.GYM.Models.Persona;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {

    public Persona profesorRequestToPersona(ProfesorRequest profesorRequest) {
        Persona persona = new Persona();
        persona.setNombre(profesorRequest.getPersona().getNombre());
        persona.setApellido(profesorRequest.getPersona().getApellido());
        persona.setDni(profesorRequest.getPersona().getDni());
        persona.setDireccion(profesorRequest.getPersona().getDireccion());
        persona.setTelefono(profesorRequest.getPersona().getTelefono());
        persona.setMail(profesorRequest.getPersona().getMail());
        return persona;
    }
}