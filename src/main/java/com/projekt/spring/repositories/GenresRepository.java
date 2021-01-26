package com.projekt.spring.repositories;

import com.projekt.spring.entities.Director;
import com.projekt.spring.entities.Genres;
import com.projekt.spring.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface GenresRepository extends CrudRepository<Genres, Integer>, PagingAndSortingRepository<Genres, Integer> {

    Genres findBygenreId(String genreId);

    @Query("select count(*) from Genres p where p.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select c from Movie c where c.movieGenre = 'comedy'")
    Iterable<Movie> getComedies();
}