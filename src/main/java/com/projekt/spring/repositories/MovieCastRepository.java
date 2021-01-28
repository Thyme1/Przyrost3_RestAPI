package com.projekt.spring.repositories;

import com.projekt.spring.entities.MovieCast;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MovieCastRepository extends CrudRepository<MovieCast, Integer>, PagingAndSortingRepository<MovieCast, Integer> {

    MovieCast findByMovieCastId(String productId);

    @Query("select count(*) from MovieCast p where p.id = ?1")
    Integer checkIfExist(Integer id);


    @Query("select count(*) from MovieCast p")
    Iterable<MovieCast> getNumberOfCasts();
}