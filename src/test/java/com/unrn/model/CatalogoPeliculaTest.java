package unrn.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoPeliculaTest {

    @Test
    @DisplayName("Crear relación Catalogo-Pelicula correctamente")
    void crearCatalogoPelicula_funciona() {
        Catalogo catalogo = new Catalogo(1, "Estrenos", "Películas recientes");
        Pelicula pelicula = new Pelicula(1, "Matrix", LocalDate.now());

        CatalogoPelicula relacion = new CatalogoPelicula(catalogo, pelicula);

        assertEquals(catalogo, relacion.catalogo(), "El catálogo debe coincidir");
        assertEquals(pelicula, relacion.pelicula(), "La película debe coincidir");
        assertNotNull(relacion.lastUpdate(), "El lastUpdate no debe ser nulo");
    }

    @Test
    @DisplayName("Igualdad de relaciones por clave")
    void igualdadCatalogoPelicula_funciona() {
        Catalogo catalogo1 = new Catalogo(1, "Estrenos", "Películas recientes");
        Pelicula pelicula1 = new Pelicula(1, "Matrix", LocalDate.now());

        Catalogo catalogo2 = new Catalogo(1, "Estrenos", "Películas recientes");
        Pelicula pelicula2 = new Pelicula(1, "Matrix", LocalDate.now());

        CatalogoPelicula rel1 = new CatalogoPelicula(catalogo1, pelicula1);
        CatalogoPelicula rel2 = new CatalogoPelicula(catalogo2, pelicula2);

        assertEquals(rel1.id, rel2.id, "Las claves deben ser iguales");
        assertEquals(rel1, rel1, "Una relación debe ser igual a sí misma");
    }
}
