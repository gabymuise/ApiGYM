package com.example.GYM.DTOS.Response;

import lombok.Data;

@Data
public class PersonaResponse {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String mail;
    private String direccion;
}
