package com.example.GYM.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "clase")
@Entity
@Getter
@Setter
public class Clase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "duracion")
    private int duracion; // Duración en minutos

    @Column(name = "precio")
    private float precio;

}