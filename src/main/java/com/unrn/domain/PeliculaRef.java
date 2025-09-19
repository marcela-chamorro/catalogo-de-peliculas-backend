// Esto permite guardar en el catálogo una “sombra” 
//de la película, sin acceder a la base real de Película.

package com.unrn.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class PeliculaRef {

    @Id
    @Column(name = "pelicula_id")
    private int id;

    private String titulo;

    public int id() { return id; }
    public String titulo() { return titulo; }

    protected PeliculaRef() {
        // requerido por JPA
    }

    public PeliculaRef(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

   
}
