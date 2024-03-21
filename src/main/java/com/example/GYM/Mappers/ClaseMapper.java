package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.ClaseRequest;
import com.example.GYM.Models.Clase;
import org.springframework.stereotype.Component;

@Component
public class ClaseMapper {

    // Convierte un ClaseRequest a un objeto Clase
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
        // Aquí puedes añadir más asignaciones si tu entidad Clase los tiene.
        return clase;
    }

    // Actualiza un objeto Clase existente con los valores de ClaseRequest
    // Este método asume que quieres actualizar una entidad Clase existente con nuevos valores de un ClaseRequest
    public void actualizarClaseDesdeRequest(ClaseRequest claseRequest, Clase claseExistente) {
        if (claseRequest == null || claseExistente == null) {
            return;
        }

        claseExistente.setNombre(claseRequest.getNombre());
        claseExistente.setDescripcion(claseRequest.getDescripcion());
        claseExistente.setTipo(claseRequest.getTipo());
        claseExistente.setDuracion(claseRequest.getDuracion());
        claseExistente.setPrecio(claseRequest.getPrecio());
        // Aquí puedes añadir más actualizaciones si tu entidad Clase los tiene.
    }
}

