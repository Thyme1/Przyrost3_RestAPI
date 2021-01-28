package com.projekt.spring.controllers;


import com.projekt.spring.entities.*;
import com.projekt.spring.services.*;
import org.joda.time.DateTime;
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
import java.util.*;

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

    @RequestMapping(value="", method=RequestMethod.GET)
    String index() {
        return "index";
    }


    @RequestMapping(value="generateModel", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        LocalDateTime localtDateAndTime=LocalDateTime.now();
        ZoneId zoneId=ZoneId.systemDefault();
        ZonedDateTime dateAndTime=ZonedDateTime.of(localtDateAndTime, zoneId);

        //TWORZYMY ADRESY
        Address address1=new Address(UUID.randomUUID().toString(), "Lipowa", "Poznan", "23", "12", "12345");
        Address address2=new Address(UUID.randomUUID().toString(), "Oak", "Nowy Jork", "12", "122", "56789");
        Address address3=new Address(UUID.randomUUID().toString(), "Angel", "Los Angeles", "27", "14", "34561");
        Address address4=new Address(UUID.randomUUID().toString(), "Sesame", "Las Vegas", "33", "22", "22222");
        Address address5=new Address(UUID.randomUUID().toString(), "Cisowa", "Warszawa", "21", "23", "11111");
        Address address6=new Address(UUID.randomUUID().toString(), "Double", "Toronto", "55", "56", "12122");

        addressService.saveAddress(address1);
        addressService.saveAddress(address2);
        addressService.saveAddress(address3);
        addressService.saveAddress(address4);
        addressService.saveAddress(address5);
        addressService.saveAddress(address6);

        //TWORZYMY AKTOROW
        Actors actor1=new Actors(UUID.randomUUID().toString(), "Johnny", "Depp", 35, "male", 231, "comedy", address2);
        Actors actor2=new Actors(UUID.randomUUID().toString(), "Morgan", "Freeman", 35, "male", 1122, "drama", address1);
        Actors actor3=new Actors(UUID.randomUUID().toString(), "Brad", "Pitt", 35, "male", 321, "comedy", address3);
        Actors actor4=new Actors(UUID.randomUUID().toString(), "Will", "Smith", 35, "male", 3412, "comedy", address4);

        actorService.saveActor(actor1);
        actorService.saveActor(actor2);
        actorService.saveActor(actor3);
        actorService.saveActor(actor4);

        //TWORZYMY FILM
        Movie movie=new Movie();
        movie.setTitle("Pirates of the Caribbean");
        movie.setLanguage("English");
        movie.setReleaseCountry("USA");
        movie.setTime("134");
        movie.setMovieGenre("comedy");
        movie.setReleaseDate(DateTime.now());
        movie.setMovieId("1");


        Movie movie2=new Movie();
        movie2.setTitle("Mank");
        movie2.setLanguage("English");
        movie2.setReleaseCountry("USA");
        movie2.setTime("134");
        movie2.setMovieGenre("drama");
        movie2.setReleaseDate(DateTime.parse("2003-05-20"));
        movie2.setMovieId("2");

        movieService.saveMovie(movie);
        movieService.saveMovie(movie2);

        //TWORZYMY REZYSEROW
        Director director=new Director();
        director.setName("Martin");
        director.setSurname("Scorsese");
        director.setDirectorId("1");
        director.setAddress(address5);
        movie.setDirector(director);


        Director director2=new Director();
        director2.setName("Steven");
        director2.setSurname("Spielberg");
        director2.setDirectorId("2");
        director2.setAddress(address6);
        movie2.setDirector(director2);

        directorService.saveDirector(director);
        directorService.saveDirector(director2);


        //TWORZYMY OBSADE
        MovieCast cast=new MovieCast();
        cast.setActor(actor1);
        cast.setMovie(movie);
        cast.setRole("pirat");
        cast.setMovieCastId("1");

        Set<MovieCast> castSet1=new HashSet<>();
        castSet1.add(cast);
        actor1.setMovies(castSet1);
        movie.setActors(castSet1);

        MovieCast cast2=new MovieCast();
        cast2.setActor(actor3);
        cast2.setMovie(movie2);
        cast2.setRole("monk");
        cast2.setMovieCastId("2");
        Set<MovieCast> castSet2=new HashSet<>();
        castSet2.add(cast2);
        movie2.setActors(castSet2);

        movieCastService.saveMovieCast(cast);
        movieCastService.saveMovieCast(cast2);

        //TWORZYMY GATUNEK
        Genres genre=new Genres();
        genre.setName("comedy");
        genre.setGenreId("1");

        Genres genre2=new Genres();
        genre2.setName("drama");
        genre2.setGenreId("2");

        genreService.saveGenres(genre);
        genreService.saveGenres(genre2);

        return "Model Generated";
    }

    public String forTesting(){

        Address address1=new Address(UUID.randomUUID().toString(), "Lipowa", "Poznan", "23", "12", "12345");
        Actors actor2=new Actors(UUID.randomUUID().toString(), "Morgan", "Freeman", 35, "male", 1122, "drama", address1);
        actorService.saveActor(actor2);

        Genres genre2=new Genres();
        genre2.setName("drama");
        genre2.setGenreId("2");

        genreService.saveGenres(genre2);

        return "done";

    }

}

