package pt.iade.youchoose.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

import pt.iade.youchoose.models.Tutorial;
import pt.iade.youchoose.models.repositories.TutorialRepository;


@RestController
@RequestMapping(path = "/api/tutoriais")
public class TutorialController {
    private Logger logger = LoggerFactory.getLogger(TutorialController.class);
    @Autowired
    private TutorialRepository TutorialRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tutorial> getTutorial() {
        logger.info("Sending all users");
        return TutorialRepository.findAll();
    }

    @GetMapping(path = "/{tutorialId:[0-30]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Tutorial getTutorialname(@PathVariable("tutorialId") Integer tutorialId) {
    logger.info("Sending tutorial with id "+ tutorialId);
    Optional<Tutorial> _tutorial = TutorialRepository.findById(tutorialId);
    if (!_tutorial.isPresent()) {
      try {
        throw new NotFoundException(""+tutorialId+"Tutorial" + "id");
    } catch (NotFoundException e){}
    }
    return _tutorial.get();
  } 
     
}