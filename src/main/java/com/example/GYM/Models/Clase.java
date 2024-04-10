package com.example.GYM.Models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clase")
@Getter
@Setter
public class Clase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String nombre;

    private String descripcion;

    private String tipo;

    private Integer duracion; // Duración en minutos

    private Double precio;

}