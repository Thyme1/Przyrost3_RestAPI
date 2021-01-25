package com.projekt.spring.repositories;

import com.projekt.spring.entities.Director;
import com.projekt.spring.entities.Genres;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface GenresRepository extends CrudRepository<Genres, Integer>, PagingAndSortingRepository<Genres, Integer> {

    Genres findByGenresId(String productId);

    @Query("select count(*) from Genres p where p.id = ?1")
    Integer checkIfExist(Integer id);



}