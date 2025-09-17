package unrn.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogo {
    static final String ERROR_NOMBRE_VACIO = "El nombre del catálogo no puede estar vacío";

    private final int id; // catalogo_id
    private final String nombre;
    private final String descripcion;
    private LocalDateTime lastUpdate;
    private final List<Pelicula> peliculas;

    public Catalogo(int id, String nombre, String descripcion) {
        assertNombreValido(nombre);
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lastUpdate = LocalDateTime.now();
        this.peliculas = new ArrayList<>();
    }

    private void assertNombreValido(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new RuntimeException(ERROR_NOMBRE_VACIO);
    }

    public void agregarPelicula(Pelicula pelicula) {
        if (!peliculas.contains(pelicula)) {
            peliculas.add(pelicula);
            actualizarLastUpdate();
        }
    }

    public void quitarPelicula(Pelicula pelicula) {
        if (peliculas.remove(pelicula)) {
            actualizarLastUpdate();
        }
    }

    private void actualizarLastUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    public int id() { return id; }
    public String nombre() { return nombre; }
    public String descripcion() { return descripcion; }
    public LocalDateTime lastUpdate() { return lastUpdate; }
    public List<Pelicula> peliculas() { return Collections.unmodifiableList(peliculas); }
}
