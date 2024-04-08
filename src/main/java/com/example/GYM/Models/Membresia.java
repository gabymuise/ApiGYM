package com.example.GYM.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "membresia")
@Getter
@Setter
public class Membresia {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String tipo;
    private int duracionMeses;
    private float precio;
}
