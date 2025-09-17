package unrn.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import unrn.model.Catalogo;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CatalogoRepositoryTest {

    @Autowired
    CatalogoRepository repository;

    @Test
    @DisplayName("Guardar y buscar catálogo")
    void guardarYBuscarCatalogo_funciona() {
        Catalogo catalogo = new Catalogo(0, "Estrenos", "Recientes");
        repository.save(catalogo);

        assertEquals(1, repository.findAll().size());
        assertEquals("Estrenos", repository.findAll().get(0).nombre());
    }
}
