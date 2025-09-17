package com.unrn.dto;

import java.time.LocalDate;
import java.util.List;

public class CatalogoPeliculaDTO {
    private final int id;
    private final String titulo;
    private final LocalDate fechaSalida;
    private final double precio;
    private final String condicion;
    private final String formato;
    private final String sinopsis;
    private final String imagenAmpliada;
    private final List<String> directores;
    private final List<String> actores;
    private final List<String> generos;

    public CatalogoPeliculaDTO(int id, String titulo, LocalDate fechaSalida, double precio,
                               String condicion, String formato, String sinopsis, String imagenAmpliada,
                               List<String> directores, List<String> actores, List<String> generos) {
        this.id = id;
        this.titulo = titulo;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.condicion = condicion;
        this.formato = formato;
        this.sinopsis = sinopsis;
        this.imagenAmpliada = imagenAmpliada;
        this.directores = List.copyOf(directores);
        this.actores = List.copyOf(actores);
        this.generos = List.copyOf(generos);
    }

    public int id() { return id; }
    public String titulo() { return titulo; }
    public LocalDate fechaSalida() { return fechaSalida; }
    public double precio() { return precio; }
    public String condicion() { return condicion; }
    public String formato() { return formato; }
    public String sinopsis() { return sinopsis; }
    public String imagenAmpliada() { return imagenAmpliada; }
    public List<String> directores() { return directores; }
    public List<String> actores() { return actores; }
    public List<String> generos() { return generos; }
}
