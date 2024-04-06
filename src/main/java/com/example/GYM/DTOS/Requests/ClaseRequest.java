package com.example.GYM.DTOS.Requests;

import lombok.Data;

@Data
public class ClaseRequest {
    private String nombre;
    private String descripcion;
    private String tipo;
    private int duracion; // Duración en minutos
    private float precio;
}