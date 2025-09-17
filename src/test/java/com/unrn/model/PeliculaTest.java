package unrn.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    @Test
    @DisplayName("Crear película con nombre válido")
    void crearPelicula_valido_funciona() {
        Pelicula p = new Pelicula(1, "Matrix", LocalDate.now());
        assertEquals("Matrix", p.nombre());
    }

    @Test
    @DisplayName("Crear película con nombre vacío lanza excepción")
    void crearPelicula_nombreVacio_excepcion() {
        var ex = assertThrows(RuntimeException.class, () -> new Pelicula(1, "", LocalDate.now()));
        assertEquals(Pelicula.ERROR_NOMBRE_VACIO, ex.getMessage());
    }
}
