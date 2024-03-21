package com.example.GYM.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "profesor")
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Persona persona;

    @OneToMany
    private List<Clase> clases;

}