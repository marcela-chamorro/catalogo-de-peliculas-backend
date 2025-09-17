package com.example.peliculas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/catalogo-peliculas")
public class CatalogoPeliculaController {

    private final CatalogoPeliculaService service;

    public CatalogoPeliculaController(CatalogoPeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CatalogoPelicula>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoPelicula> getById(@PathVariable Long id) {
        Optional<CatalogoPelicula> opt = service.findById(id);
        return opt.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CatalogoPelicula> create(@Valid @RequestBody CatalogoPelicula body) {
        CatalogoPelicula created = service.save(body);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogoPelicula> update(@PathVariable Long id,
                                                   @Valid @RequestBody CatalogoPelicula body) {
        Optional<CatalogoPelicula> updated = service.update(id, body);
        return updated.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        if (deleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}
