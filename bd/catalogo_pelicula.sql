
CREATE FUNCTION set_last_update_func() RETURNS TRIGGER 
AS $$  
BEGIN
  NEW.last_update = CURRENT_TIMESTAMP;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Tabla catálogo
CREATE TABLE catalogos (
  catalogo_id SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  descripcion TEXT,
  last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER catalogo_before_update BEFORE UPDATE ON catalogos 
FOR EACH ROW EXECUTE FUNCTION set_last_update_func();

-- Relación Catálogo - Películas
CREATE TABLE catalogo_peliculas (
  catalogo_id INT NOT NULL,
  pelicula_id INT NOT NULL,
  last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (catalogo_id, pelicula_id),
  CONSTRAINT fk_cat_pel_catalogo FOREIGN KEY (catalogo_id) REFERENCES catalogos(catalogo_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_cat_pel_pelicula FOREIGN KEY (pelicula_id) REFERENCES peliculas(pelicula_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TRIGGER catalogo_peliculas_before_update BEFORE UPDATE ON catalogo_peliculas 
FOR EACH ROW EXECUTE FUNCTION set_last_update_func();

CREATE INDEX idx_cat_pel_catalogo ON catalogo_peliculas(catalogo_id);
CREATE INDEX idx_cat_pel_pelicula ON catalogo_peliculas(pelicula_id);

-- Puedes agregar más tablas de relación si tu catálogo necesita clasificaciones, favoritos, etc.