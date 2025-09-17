package unrn.controllers;

import unrn.model.Catalogo;
import unrn.model.Pelicula;
import unrn.services.CatalogoService;

import java.util.List;

public class CatalogoController {

    private final CatalogoService service;

    public CatalogoController(CatalogoService service) {
        this.service = service;
    }

    /**
     * Crear un nuevo catálogo
     */
    public void crearCatalogo(Catalogo catalogo) {
        service.agregarCatalogo(catalogo);
    }

    /**
     * Agregar película a un catálogo existente
     */
    public void agregarPeliculaACatalogo(Catalogo catalogo, Pelicula pelicula) {
        service.agregarPeliculaACatalogo(catalogo, pelicula);
    }

    /**
     * Quitar película de un catálogo
     */
    public void quitarPeliculaDeCatalogo(Catalogo catalogo, Pelicula pelicula) {
        service.quitarPeliculaDeCatalogo(catalogo, pelicula);
    }

    /**
     * Listar todos los catálogos
     */
    public List<Catalogo> listarCatalogos() {
        return service.listarCatalogos();
    }

    /**
     * Listar todas las películas de un catálogo específico
     */
    public List<Pelicula> listarPeliculasDeCatalogo(Catalogo catalogo) {
        return service.listarPeliculasDeCatalogo(catalogo);
    }
}
