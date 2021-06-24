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

import pt.iade.youchoose.models.Forum;
import pt.iade.youchoose.models.repositories.ForumRepository;


@RestController
@RequestMapping(path = "/api/forum")
public class ForumController {
    private Logger logger = LoggerFactory.getLogger(ForumController.class);
    @Autowired
    private ForumRepository ForumRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Forum> getForum() {
        logger.info("Sending all forum");
        return ForumRepository.findAll();
    }

    @GetMapping(path = "/{forumId:[0-30]+}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Forum getForumname(@PathVariable("forumId") Integer forumId) {
    logger.info("Sending forum with id "+ forumId);
    Optional<Forum> _forum = ForumRepository.findById(forumId);
    if (!_forum.isPresent()) {
      try {
        throw new NotFoundException(""+forumId+"Forum" + "id");
    } catch (NotFoundException e){}
    }
    return _forum.get();
  } 
     
}

