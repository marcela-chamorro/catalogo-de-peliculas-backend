package unrn.controllers;

import unrn.model.Pelicula;
import unrn.services.PeliculaService;

import java.util.List;

public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    public void crearPelicula(Pelicula pelicula) {
        service.agregarPelicula(pelicula);
    }

    public List<Pelicula> listarPeliculas() {
        return service.listarPeliculas();
    }
}
