package pt.iade.youchoose.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

import pt.iade.youchoose.models.Utilizador;
import pt.iade.youchoose.models.repositories.UtilizadorRepository;


@RestController
@RequestMapping(path = "/api/utilizadores")
public class UtilizadorController {
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class);
    @Autowired
    private UtilizadorRepository UtilizadorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadores() {
        logger.info("Sending all users");
        return UtilizadorRepository.findAll();
    }

    @GetMapping(path = "/{utilizadorId:[0-30]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizadorname(@PathVariable("utilizadorId") Integer utilizadorId) {
    logger.info("Sending user with id "+ utilizadorId);
    Optional<Utilizador> _utilizador = UtilizadorRepository.findById(utilizadorId);
    if (!_utilizador.isPresent()) {
      try {
        throw new NotFoundException(""+utilizadorId+"Utilizador" + "id");
    } catch (NotFoundException e){}
    }
    return _utilizador.get();
  } 
  @GetMapping(path = "/escalao/{escId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadorByEscalao(@PathVariable("escId") Integer escId) {
    logger.info("Sending user of escalao with id "+ escId);
    return UtilizadorRepository.findByEscalaoId(escId);
    
  }    

  @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)

      public Utilizador saveUser(@RequestBody Utilizador newUtilizador) {

        Utilizador utilizador = UtilizadorRepository.save(newUtilizador);

        logger.info("Saving new user with id "+ utilizador.getId() );

      return utilizador;

    }
  }

