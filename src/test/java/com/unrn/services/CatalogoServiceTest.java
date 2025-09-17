package unrn.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unrn.model.Catalogo;
import unrn.model.Pelicula;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoServiceTest {

    @Test
    @DisplayName("Agregar y listar películas de un catálogo")
    void agregarPeliculaACatalogo_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Películas recientes");
        Pelicula pelicula = new Pelicula(1, "Matrix", LocalDate.now());

        CatalogoService service = new CatalogoService();
        service.agregarCatalogo(catalogo);
        service.agregarPeliculaACatalogo(catalogo, pelicula);

        assertTrue(service.listarPeliculasDeCatalogo(catalogo).contains(pelicula),
                "El catálogo debe contener la película agregada");
    }

    @Test
    @DisplayName("Quitar película de un catálogo")
    void quitarPeliculaDeCatalogo_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Películas recientes");
        Pelicula pelicula = new Pelicula(1, "Matrix", LocalDate.now());

        CatalogoService service = new CatalogoService();
        service.agregarCatalogo(catalogo);
        service.agregarPeliculaACatalogo(catalogo, pelicula);

        service.quitarPeliculaDeCatalogo(catalogo, pelicula);
        assertFalse(service.listarPeliculasDeCatalogo(catalogo).contains(pelicula),
                "La película debe haber sido removida del catálogo");
    }
}
