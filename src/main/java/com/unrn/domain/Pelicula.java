package com.unrn.domain;

import jakarta.persistence.*;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String nombre;
    public String director;
    public int año;

    public Pelicula() {
    } // Necesario para JPA

    public Pelicula(String nombre, String director, int año) {
        this.nombre = nombre;
        this.director = director;
        this.año = año;
    }
}
