package com.unrn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import com.unrn.dto.CatalogoDTO;
import com.unrn.services.CatalogoService;

@RestController
@RequestMapping("/api/catalogos")
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @PostMapping
    public ResponseEntity<CatalogoDTO> crearCatalogo(@RequestParam String nombre,
                                                     @RequestParam String descripcion) {

    CatalogoDTO catalogoDTO = new CatalogoDTO(nombre, descripcion);
    return ResponseEntity.ok(catalogoService.saveCatalogo(catalogoDTO));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CatalogoDTO> buscarCatalogo(@PathVariable int id) {
        return ResponseEntity.ok(catalogoService.buscarCatalogoPorId(id));
    }

    @PostMapping("/catalogo")
    public CatalogoDTO saveCatalogo(@RequestBody CatalogoDTO catalogoDTO) {
        return catalogoService.saveCatalogo(catalogoDTO);
    }
}

