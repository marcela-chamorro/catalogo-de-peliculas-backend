package com.unrn.domain;

import java.time.LocalDate;

public class Pelicula {
    static final String ERROR_NOMBRE_VACIO = "El nombre de la película no puede estar vacío";

    private final int id; // pelicula_id
    private final String nombre;
    private final LocalDate fechaSalida;

    public Pelicula(int id, String nombre, LocalDate fechaSalida) {
        assertNombreValido(nombre);
        this.id = id;
        this.nombre = nombre;
        this.fechaSalida = fechaSalida;
    }

    private void assertNombreValido(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new RuntimeException(ERROR_NOMBRE_VACIO);
    }

    public int id() { return id; }
    public String nombre() { return nombre; }
    public LocalDate fechaSalida() { return fechaSalida; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula p = (Pelicula) o;
        return id == p.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
