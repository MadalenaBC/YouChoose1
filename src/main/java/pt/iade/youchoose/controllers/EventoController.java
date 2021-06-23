package pt.iade.youchoose.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Iterable<Evento> getUtilizasdores() {
        logger.info("Sending all events");
        return EventoRepository.findAll();
    }

}

