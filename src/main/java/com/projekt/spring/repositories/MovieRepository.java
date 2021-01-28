package com.projekt.spring.repositories;

import com.projekt.spring.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MovieRepository extends CrudRepository<Movie, Integer>, PagingAndSortingRepository<Movie, Integer> {

    Movie findByMovieId(String productId);

    @Query("select count(*) from Movie p where p.id = ?1")
    Integer checkIfExist(Integer id);


    @Query("select m from Movie m where m.time = (select max(time) from m)")
    Iterable<Movie> getLongestMovie();
}