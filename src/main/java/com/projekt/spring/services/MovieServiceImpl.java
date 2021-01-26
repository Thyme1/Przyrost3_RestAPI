package com.projekt.spring.services;

import com.projekt.spring.entities.Genres;
import com.projekt.spring.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Movie service implement.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private com.projekt.spring.repositories.MovieRepository movieRepository;



    @Override
    public Iterable<Movie> listAllMovies() {
        return movieRepository.findAll();
    }


    @Override
    public Iterable<Movie> getMovieById(Integer id) {
        return movieRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public Movie saveMovie(Movie product) {
        return movieRepository.save(product);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (movieRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


    @Override
    public Iterable<Movie> listAllMoviesPaging(Integer pageNr, Integer howManyOnPage) {
        return movieRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Movie> getLongestMovie() {
        return movieRepository.getLongestMovie();
    }


}