package unrn.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unrn.model.Catalogo;
import unrn.model.Pelicula;
import unrn.services.CatalogoService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoControllerTest {

    @Test
    @DisplayName("Agregar película a catálogo desde controller")
    void agregarPeliculaACatalogo_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Recientes");
        Pelicula pelicula = new Pelicula(1, "Matrix", LocalDate.now());
        CatalogoService service = new CatalogoService();
        CatalogoController controller = new CatalogoController(service);

        controller.crearCatalogo(catalogo);
        controller.agregarPeliculaACatalogo(catalogo, pelicula);

        assertTrue(controller.listarPeliculasDeCatalogo(catalogo).contains(pelicula));
    }

    @Test
    @DisplayName("Quitar película de catálogo desde controller")
    void quitarPeliculaDeCatalogo_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Recientes");
        Pelicula pelicula = new Pelicula(1, "Matrix", LocalDate.now());
        CatalogoService service = new CatalogoService();
        CatalogoController controller = new CatalogoController(service);

        controller.crearCatalogo(catalogo);
        controller.agregarPeliculaACatalogo(catalogo, pelicula);
        controller.quitarPeliculaDeCatalogo(catalogo, pelicula);

        assertFalse(controller.listarPeliculasDeCatalogo(catalogo).contains(pelicula));
    }
}