package unrn.services;

import unrn.model.Catalogo;
import unrn.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class CatalogoService {
    private final List<Catalogo> catalogos = new ArrayList<>();

    public void agregarCatalogo(Catalogo catalogo) {
        catalogos.add(catalogo);
    }

    public void agregarPeliculaACatalogo(Catalogo catalogo, Pelicula pelicula) {
        catalogo.agregarPelicula(pelicula);
    }

    public void quitarPeliculaDeCatalogo(Catalogo catalogo, Pelicula pelicula) {
        catalogo.quitarPelicula(pelicula);
    }

    public List<Catalogo> listarCatalogos() {
        return List.copyOf(catalogos);
    }

    public List<Pelicula> listarPeliculasDeCatalogo(Catalogo catalogo) {
        return catalogo.peliculas();
    }
}
