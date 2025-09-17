package unrn.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "catalogo_peliculas")
public class CatalogoPelicula {

    @Embeddable
    public static class Key implements Serializable {
        @Column(name = "catalogo_id")
        private int catalogoId;

        @Column(name = "pelicula_id")
        private int peliculaId;

        public Key() {}

        public Key(int catalogoId, int peliculaId) {
            this.catalogoId = catalogoId;
            this.peliculaId = peliculaId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return catalogoId == key.catalogoId && peliculaId == key.peliculaId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(catalogoId, peliculaId);
        }
    }

    @EmbeddedId
    private Key id;

    @ManyToOne
    @MapsId("catalogoId")
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

    @ManyToOne
    @MapsId("peliculaId")
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public CatalogoPelicula() {}

    public CatalogoPelicula(Catalogo catalogo, Pelicula pelicula) {
        this.catalogo = catalogo;
        this.pelicula = pelicula;
        this.id = new Key(catalogo.id(), pelicula.id());
        this.lastUpdate = LocalDateTime.now();
    }

    public Catalogo catalogo() { return catalogo; }
    public Pelicula pelicula() { return pelicula; }
    public LocalDateTime lastUpdate() { return lastUpdate; }
}
