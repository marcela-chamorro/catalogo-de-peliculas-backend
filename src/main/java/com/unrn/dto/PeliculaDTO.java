package com.unrn.dto;

public class PeliculaDTO {

    static final String ERROR_ID_INVALIDO = "El id de la película debe ser mayor que cero";
    static final String ERROR_TITULO_VACIO = "El título de la película no puede estar vacío";

    private final int id;
    private final String titulo;
    public Object nombre;

    public PeliculaDTO(int id, String titulo) {
        if (id <= 0) throw new RuntimeException(ERROR_ID_INVALIDO);
        if (titulo == null || titulo.isBlank()) throw new RuntimeException(ERROR_TITULO_VACIO);
        this.id = id;
        this.titulo = titulo;
    }

    public int id() { return id; }
    public String titulo() { return titulo; }

    @Override
    public String toString() { return "PeliculaDTO{id=%d, titulo='%s'}".formatted(id, titulo); }
}