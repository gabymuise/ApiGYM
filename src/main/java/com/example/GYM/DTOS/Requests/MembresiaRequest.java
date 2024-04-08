package com.example.GYM.DTOS.Requests;

import lombok.Data;

@Data
public class MembresiaRequest {
    private String tipo;
    private int duracionMeses;
    private float precio;
}
