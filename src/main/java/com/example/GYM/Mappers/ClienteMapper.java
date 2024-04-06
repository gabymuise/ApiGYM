package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.ClienteRequest;
import com.example.GYM.Models.Persona;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Persona clienteRequestToPersona(ClienteRequest clienteRequest) {
        Persona persona = new Persona();
        persona.setNombre(clienteRequest.getPersona().getNombre());
        persona.setApellido(clienteRequest.getPersona().getApellido());
        persona.setDni(clienteRequest.getPersona().getDni());
        persona.setDireccion(clienteRequest.getPersona().getDireccion());
        persona.setTelefono(clienteRequest.getPersona().getTelefono());
        persona.setMail(clienteRequest.getPersona().getMail());
        return persona;
    }
}