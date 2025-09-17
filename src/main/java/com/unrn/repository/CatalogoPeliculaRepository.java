package unrn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unrn.model.Pelicula;
import unrn.model.Catalogo;
import unrn.model.CatalogoPelicula;

import java.util.List;

@Repository
public interface CatalogoPeliculaRepository extends JpaRepository<CatalogoPelicula, CatalogoPelicula.Key> {
    List<CatalogoPelicula> findByCatalogo(Catalogo catalogo);
    List<CatalogoPelicula> findByPelicula(Pelicula pelicula);
}
