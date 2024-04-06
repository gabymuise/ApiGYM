package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.ProfesorRequest;
import com.example.GYM.Mappers.ProfesorMapper;
import com.example.GYM.Models.Profesor;
import com.example.GYM.Repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorMapper profesorMapper;

    public String registrarProfesor(ProfesorRequest profesorRequest) {
        Profesor profesor = new Profesor();
        profesor.setPersona(profesorMapper.profesorRequestToPersona(profesorRequest));
        profesorRepository.save(profesor);
        return "Profesor guardado: " + profesor.getPersona().getNombre() + " " + profesor.getPersona().getApellido();
    }

    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}