package com.projekt.spring.services;


import com.projekt.spring.entities.MovieCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * MovieCast service implement.
 */
@Service
public class MovieCastServiceImpl implements MovieCastService {

    @Autowired
    private com.projekt.spring.repositories.MovieCastRepository movieCastRepository;


    @Override
    public Iterable<MovieCast> listAllMovieCasts() {
        return movieCastRepository.findAll();
    }


    @Override
    public Iterable<MovieCast> getMovieCastById(Integer id) {
        return movieCastRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public MovieCast saveMovieCast(MovieCast product) {
        return movieCastRepository.save(product);
    }

    @Override
    public void deleteMovieCast(Integer id) {
        movieCastRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (movieCastRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<MovieCast> getNumberOfCasts() {
        return movieCastRepository.getNumberOfCasts();    }


}