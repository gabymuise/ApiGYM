package com.example.GYM.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Table(name = "persona")
@Entity
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    private String mail;

    @Column(name = "direccion")
    private String direccion;
}
