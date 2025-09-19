// Esto permite guardar en el catálogo una “sombra” 
//de la película, sin acceder a la base real de Película.

package com.unrn.domain;

import jakarta.persistence.*;

@Entity
public class PeliculaRef {
    @Id
    private Integer idPelicula;   // ID real de la película en el microservicio de películas
    private String nombre;

    public PeliculaRef() {}

    public PeliculaRef(Integer idPelicula, String nombre) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
    }
}


   

