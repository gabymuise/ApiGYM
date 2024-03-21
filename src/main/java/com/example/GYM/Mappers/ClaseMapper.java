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

        // Aquí debes asignar los valores de los campos de claseRequest a los de clase.
        // Ejemplo:
        // clase.setNombre(claseRequest.getNombre());
        // Más asignaciones aquí...

        return clase;
    }
    public static Clase toEntity(ClaseRequest claseRequest) {
        Clase clase = new Clase();
        clase.setNombre(claseRequest.getNombre());
        clase.setDescripcion(claseRequest.getDescripcion());
        clase.setTipo(claseRequest.getTipo());
        clase.setDuracion(claseRequest.getDuracion());
        clase.setPrecio(claseRequest.getPrecio());
        // Aquí puedes añadir más campos si tu entidad Clase los tiene.
        return clase;
    }

    // Actualiza un objeto Clase existente con los valores de ClaseRequest
    // Este método asume que quieres actualizar una entidad Clase existente con nuevos valores de un ClaseRequest
    public Clase actualizarClaseDesdeRequest(ClaseRequest claseRequest, Clase claseExistente) {
        if (claseRequest == null || claseExistente == null) {
            return null;
        }

        // Aquí debes actualizar los campos de claseExistente con los valores de claseRequest.
        // Ejemplo:
        // claseExistente.setNombre(claseRequest.getNombre());
        // Más actualizaciones aquí...

        return claseExistente;
    }
}
