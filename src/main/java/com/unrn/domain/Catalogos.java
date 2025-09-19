package com.unrn.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "catalogos")
public class Catalogos {

    // Constantes de validación
    static final String ERROR_NOMBRE_VACIO = "El nombre del catálogo no puede estar vacío";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogo_id")
    private int catalogo_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name = "catalogo_peliculas", joinColumns = @JoinColumn(name = "catalogo_id"), inverseJoinColumns = @JoinColumn(name = "pelicula_id"))

    private List<PeliculaRef> peliculas = new ArrayList<>();

    // Constructor
    public Catalogos(String nombre, String descripcion) {
        assertNombreValido(nombre);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lastUpdate = LocalDateTime.now();
    }

    // Métodos de negocio
    private void assertNombreValido(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new RuntimeException(ERROR_NOMBRE_VACIO);
    }

    public void agregarPelicula(PeliculaRef pelicula) {
        if (!peliculas.contains(pelicula)) {
            peliculas.add(pelicula);
            actualizarLastUpdate();
        }
    }

    public void quitarPelicula(PeliculaRef pelicula) {
        if (peliculas.remove(pelicula)) {
            actualizarLastUpdate();
        }
    }

    private void actualizarLastUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    public List<PeliculaRef> peliculas() {
        return Collections.unmodifiableList(peliculas);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
