package unrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unrn.model.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
    // JpaRepository ya provee métodos CRUD y de búsqueda básica
}
