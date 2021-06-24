package pt.iade.youchoose.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.youchoose.models.repositories.EventoRepository;
import pt.iade.youchoose.models.Evento;


@RestController
@RequestMapping(path = "/api/evento")
public class EventoController {
    private Logger logger = LoggerFactory.getLogger(EventoController.class);
    @Autowired
    private EventoRepository EventoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Evento> getUtilizadores() {
        logger.info("Sending all events");
        return EventoRepository.findAll();
    }
    @GetMapping(path = "/tipoevento/{tipoeventoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Evento> getTipoEventoByEvento(@PathVariable("tipoeventoId")Integer tipoeventoId) {
        logger.info("Sending all id of type of events" + tipoeventoId);
        return EventoRepository.findBytevid(tipoeventoId);
    }
}

