package com.projekt.spring.services;
import com.projekt.spring.entities.Genres;
import java.util.Optional;


public interface GenresService {

    Iterable<Genres> listAllGenres();

    Optional<Genres> getGenreById(Integer id);

    Genres saveGenre(Genres product);

    void deleteGenre(Integer id);

    Boolean checkIfExist(Integer id);



}
