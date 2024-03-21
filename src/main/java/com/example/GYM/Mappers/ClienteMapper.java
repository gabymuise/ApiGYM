package com.example.GYM.Mappers;


import com.example.GYM.DTOS.Requests.ClienteRequest;
import com.example.GYM.Models.Persona;
import com.example.GYM.Services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    @Autowired
    private ClaseService claseService;

    //public Profesor profesorRequestToProfesor(ProfesorRequest profesorRequest, Profesor profesor)

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