

package pt.iade.youchoose.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.youchoose.models.repositories.CodigoPostalRepository;
import pt.iade.youchoose.models.CodigoPostal;


@RestController
@RequestMapping(path = "/api/youchoose3")
public class CodigoPostalController {
    private Logger logger = LoggerFactory.getLogger(CodigoPostalController.class);
    @Autowired
    private CodigoPostalRepository CodigoPostalRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodigoPostal> getUtilizasdores() {
        logger.info("Sending all post code");
        return CodigoPostalRepository.findAll();
    }

}
    

