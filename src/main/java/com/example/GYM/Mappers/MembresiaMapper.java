package com.example.GYM.Mappers;

import com.example.GYM.DTOS.Requests.MembresiaRequest;
import com.example.GYM.DTOS.Response.MembresiaResponse;
import com.example.GYM.Models.Membresia;
import org.springframework.stereotype.Component;

@Component
public class MembresiaMapper {

    public Membresia toMembresia(MembresiaRequest request) {
        Membresia membresia = new Membresia();
        membresia.setTipo(request.getTipo());
        membresia.setDuracionMeses(request.getDuracionMeses());
        membresia.setPrecio(request.getPrecio());
        return membresia;
    }

    public MembresiaResponse toMembresiaResponse(Membresia membresia) {
        MembresiaResponse response = new MembresiaResponse();
        response.setId(membresia.getId());
        response.setTipo(membresia.getTipo());
        response.setDuracionMeses(membresia.getDuracionMeses());
        response.setPrecio(membresia.getPrecio());
        return response;
    }
}
