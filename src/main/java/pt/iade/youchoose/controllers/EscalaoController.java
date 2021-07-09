package pt.iade.youchoose.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.youchoose.models.repositories.EscalaoRepository;
import pt.iade.youchoose.models.Escalao;


@RestController
@RequestMapping(path = "/api/youchoose4")
public class EscalaoController {
    private Logger logger = LoggerFactory.getLogger(EscalaoController.class);
    @Autowired
    private EscalaoRepository EscalaoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Escalao> getEscalao() {
        logger.info("Sending all Escaloes");
        return EscalaoRepository.findAll();
    }

}


