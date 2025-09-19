//el catálogo solo recibe películas vía RabbitMQ, 
//no accede a la BD de Película.

package com.unrn.services;

import com.unrn.domain.PeliculaRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unrn.domain.Catalogos;
import com.unrn.domain.Pelicula;
import com.unrn.dto.CatalogoDTO;
import com.unrn.dto.PeliculaDTO;
import com.unrn.repository.CatalogoRepository;
import com.unrn.repository.PeliculaRefRepository;

@Service
@Transactional
public class CatalogoService {

    @Autowired()
    private CatalogoRepository catalogoRepository;
    @Autowired()
    private PeliculaRefRepository peliculaRefRepository;

    // Método para guardar un catálogo
    public CatalogoDTO saveCatalogo(CatalogoDTO catalogoDTO) {
        Catalogos catalogo = new Catalogos(
                catalogoDTO.nombre,
                catalogoDTO.descripcion

        );
        catalogoRepository.save(catalogo);
        return toDTO(catalogo);
    }

    // buscar catalogo por id
    public CatalogoDTO buscarCatalogoPorId(int id) {
        Catalogos catalogo = catalogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catálogo no encontrado con ID: " + id));
        return toDTO(catalogo);
    }

    // Conversión a DTO
    private CatalogoDTO toDTO(Catalogos catalogo) {
        return new CatalogoDTO(catalogo.getNombre(), catalogo.getDescripcion());
    }

    public void agregarPeliculaDesdeEvento(PeliculaDTO peliculaDTO) {
        PeliculaRef ref = new PeliculaRef(
                peliculaDTO.getId(),      // id que viene del microservicio de películas
                peliculaDTO.getNombre()
        );

        peliculaRefRepository.save(ref);
    }

}
