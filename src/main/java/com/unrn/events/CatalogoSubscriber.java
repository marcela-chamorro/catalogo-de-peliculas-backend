package com.unrn.events;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.unrn.dto.PeliculaDTO;
import com.unrn.services.CatalogoService;

@Component
public class CatalogoSubscriber {

    private final CatalogoService catalogoService;

    public CatalogoSubscriber(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @RabbitListener(queues = "peliculas.queue")
    public void onPeliculaCreada(PeliculaDTO peliculaDTO) {
        catalogoService.agregarPeliculaDesdeEvento(peliculaDTO);
    }
}
