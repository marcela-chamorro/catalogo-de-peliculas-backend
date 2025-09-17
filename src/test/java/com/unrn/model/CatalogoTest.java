package unrn.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.unrn.domain.Catalogo;
import com.unrn.domain.Pelicula;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {

    @Test
    @DisplayName("Crear catálogo con nombre válido")
    void crearCatalogo_valido_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Películas recientes");
        assertEquals("Estrenos", catalogo.nombre(), "El nombre del catálogo debe coincidir");
    }

    @Test
    @DisplayName("Crear catálogo con nombre vacío lanza excepción")
    void crearCatalogo_nombreVacio_excepcion() {
        var ex = assertThrows(RuntimeException.class, () -> new Catalogo(1, "", "Desc"));
        assertEquals(Catalogo.ERROR_NOMBRE_VACIO, ex.getMessage());
    }

    @Test
    @DisplayName("Agregar y quitar película actualiza la lista")
    void agregarYQuitarPelicula_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Películas recientes");
        Pelicula p = new Pelicula(1, "Matrix", LocalDate.now());

        catalogo.agregarPelicula(p);
        assertTrue(catalogo.peliculas().contains(p), "Debe contener la película agregada");

        catalogo.quitarPelicula(p);
        assertFalse(catalogo.peliculas().contains(p), "Debe haber sido removida");
    }
}
