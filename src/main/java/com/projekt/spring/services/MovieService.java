package com.projekt.spring.services;

import com.projekt.spring.entities.Movie;
import java.util.Optional;

public interface MovieService {

    Iterable<Movie> listAllMovies();

    Optional<Movie> getMovieById(Integer id);

    Movie saveMovie(Movie product);

    void deleteMovie(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Movie> listAllMoviesPaging(Integer pageNr, Integer howManyOnPage);


    Iterable<Movie> getLongestMovie();
}
