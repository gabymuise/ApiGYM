package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.ClaseRequest;
import com.example.GYM.DTOS.Requests.ProfesorRequest;
import com.example.GYM.Models.Clase;
import com.example.GYM.Models.Persona;
import com.example.GYM.Models.Profesor;
import com.example.GYM.Services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorMapper {

    @Autowired
    private ClaseService claseService;

    //public Profesor profesorRequestToProfesor(ProfesorRequest profesorRequest, Profesor profesor)

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