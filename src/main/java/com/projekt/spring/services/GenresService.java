package com.projekt.spring.services;
import com.projekt.spring.entities.Director;
import com.projekt.spring.entities.Genres;
import com.projekt.spring.entities.Movie;

import java.util.Optional;


public interface GenresService {

    Iterable<Genres> listAllGenres();

    Optional<Genres> getGenresById(Integer id);

    Genres saveGenres(Genres product);

    void deleteGenres(Integer id);

    Boolean checkIfExist(Integer id);
    public Iterable<Genres> listAllGenresPaging(Integer pageNr, Integer howManyOnPage);


    Iterable<Movie> getComedies();
}
