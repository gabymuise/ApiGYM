package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.ClaseRequest;
import com.example.GYM.Models.Clase;
import org.springframework.stereotype.Component;

@Component
public class ClaseMapper {

    public Clase claseRequestToClase(ClaseRequest claseRequest) {
        if (claseRequest == null) {
            return null;
        }

        Clase clase = new Clase();
        clase.setNombre(claseRequest.getNombre());
        clase.setDescripcion(claseRequest.getDescripcion());
        clase.setTipo(claseRequest.getTipo());
        clase.setDuracion(claseRequest.getDuracion());
        clase.setPrecio(claseRequest.getPrecio());
        return clase;
    }

    public void actualizarClaseDesdeRequest(ClaseRequest claseRequest, Clase claseExistente) {
        if (claseRequest == null || claseExistente == null) {
            return;
        }

        claseExistente.setNombre(claseRequest.getNombre());
        claseExistente.setDescripcion(claseRequest.getDescripcion());
        claseExistente.setTipo(claseRequest.getTipo());
        claseExistente.setDuracion(claseRequest.getDuracion());
        claseExistente.setPrecio(claseRequest.getPrecio());
    }
}

