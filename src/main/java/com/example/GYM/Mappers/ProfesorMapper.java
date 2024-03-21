package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.MateriaRequest;
import com.example.GYM.DTOS.Requests.ProfesorRequest;
import com.example.GYM.Models.Materia;
import com.example.GYM.Models.Persona;
import com.example.GYM.Models.Profesor;
import com.example.GYM.Services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorMapper {

    @Autowired
    private MateriaService materiaService;

    public Profesor profesorRequestToProfesor(ProfesorRequest profesorRequest, Profesor profesor){
        List<Materia> materiaList = new ArrayList<>();
        for (MateriaRequest materiaRequest : profesorRequest.getMaterias()) {
            Materia materia = new Materia();
            materia.setNombre(materiaRequest.getNombre());
            materia.setAnio(materiaRequest.getAnio());
            materia = materiaService.setMateriaNuevaOExistente(materiaRequest, materia);
            materiaList.add(materia);
        }
        profesor.setMaterias(materiaList);
        return profesor;
    }

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
