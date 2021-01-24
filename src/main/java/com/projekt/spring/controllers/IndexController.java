package com.projekt.spring.controllers;




import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Address;
import com.projekt.spring.entities.Director;
import com.projekt.spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private GenresService genreService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieCastService movieCastService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() {
        return "index";
    }


    @RequestMapping(value = "generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);

        Actors a1 = new Actors();
        Actors a2 = new Actors();
        Actors a3 = new Actors();

        Address address1 = new Address("Biedra", "Poznan", Arrays.asList(p1.getProductId(), p2.getProductId(), p3.getProductId()));
        Address address2 = new Address("Lidl", "Krosno", Arrays.asList(p1.getProductId(), p2.getProductId()));

        p1.getSellers().add(seller);
        p2.getSellers().add(seller);
        p3.getSellers().add(seller);
        p1.getSellers().add(seller2);
        p2.getSellers().add(seller2);

        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);

        return "Model Generated";
    }

}

