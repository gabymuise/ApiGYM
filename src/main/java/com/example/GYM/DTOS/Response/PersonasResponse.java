package com.example.GYM.DTOS.Response;

import lombok.Data;

import java.util.List;

@Data
public class PersonasResponse {
    private List<PersonaResponse> personas;
}
