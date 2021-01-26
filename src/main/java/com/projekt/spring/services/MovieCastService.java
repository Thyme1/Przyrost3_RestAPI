package com.projekt.spring.services;

import com.projekt.spring.entities.MovieCast;
import java.util.Optional;

public interface MovieCastService {

    Iterable<MovieCast> listAllMovieCasts();

    Iterable<MovieCast> getMovieCastById(Integer id);

    MovieCast saveMovieCast(MovieCast product);

    void deleteMovieCast(Integer id);

    Boolean checkIfExist(Integer id);


}
