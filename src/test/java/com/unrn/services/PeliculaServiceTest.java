package unrn.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unrn.model.Pelicula;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaServiceTest {

    @Test
    @DisplayName("Agregar y listar películas")
    void agregarYListarPeliculas_funciona() {
        PeliculaService service = new PeliculaService();
        Pelicula p1 = new Pelicula(1, "Matrix", LocalDate.now());
        Pelicula p2 = new Pelicula(2, "Inception", LocalDate.now());

        service.agregarPelicula(p1);
        service.agregarPelicula(p2);

        List<Pelicula> peliculas = service.listarPeliculas();
        assertEquals(2, peliculas.size(), "Debe listar todas las películas agregadas");
        assertTrue(peliculas.contains(p1));
        assertTrue(peliculas.contains(p2));
    }
}
