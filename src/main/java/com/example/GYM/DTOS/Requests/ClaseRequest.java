package com.example.GYM.DTOS.Requests;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClaseRequest {
    private String nombre;
    private String descripcion;
    private String tipo;
    private int duracion; // Duración en minutos
    private float precio;
}