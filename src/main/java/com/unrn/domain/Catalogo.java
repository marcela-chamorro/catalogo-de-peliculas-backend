package com.unrn.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catalogos")
public class Catalogo {
    static final String ERROR_NOMBRE_VACIO = "El nombre del catálogo no puede estar vacío";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id; // catalogo_id
   
    @Column(name="nombre")
    private  String nombre;
    
     @Column(name="descripcion")
    private  String descripcion;
   
    private LocalDateTime lastUpdate;
   
    private  List<Pelicula> peliculas;


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


    public LocalDateTime lastUpdate() { return lastUpdate; }
    public List<Pelicula> peliculas() { return Collections.unmodifiableList(peliculas); }
}
