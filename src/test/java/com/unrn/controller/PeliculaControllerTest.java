package unrn.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unrn.model.Pelicula;
import unrn.services.PeliculaService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaControllerTest {

    @Test
    @DisplayName("Crear y listar películas desde controller")
    void crearYListarPeliculas_funciona() {
        PeliculaService service = new PeliculaService();
        PeliculaController controller = new PeliculaController(service);

        Pelicula p = new Pelicula(1, "Matrix", LocalDate.now());
        controller.crearPelicula(p);

        assertTrue(controller.listarPeliculas().contains(p));
    }
}
