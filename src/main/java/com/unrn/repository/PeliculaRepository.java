package com.unrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unrn.domain.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
