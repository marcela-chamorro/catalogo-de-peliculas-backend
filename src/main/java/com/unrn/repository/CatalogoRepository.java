package com.unrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unrn.domain.Catalogos;

public interface CatalogoRepository extends JpaRepository<Catalogos, Integer> {
    
}