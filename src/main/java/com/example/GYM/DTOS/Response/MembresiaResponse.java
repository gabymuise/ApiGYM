package com.example.GYM.DTOS.Response;

import lombok.Data;

@Data
public class MembresiaResponse {
    private Long id;
    private String tipo;
    private int duracionMeses;
    private float precio;
}
