package com.example.peliculas.service;

import com.example.peliculas.model.CatalogoPelicula;

import java.util.List;
import java.util.Optional;

public interface CatalogoPeliculaService {
    List<CatalogoPelicula> findAll();
    Optional<CatalogoPelicula> findById(Long id);
    CatalogoPelicula save(CatalogoPelicula catalogoPelicula);
    Optional<CatalogoPelicula> update(Long id, CatalogoPelicula catalogoPelicula);
    boolean deleteById(Long id);
}
