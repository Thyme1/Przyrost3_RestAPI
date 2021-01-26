package com.projekt.spring.repositories;

import com.projekt.spring.entities.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface DirectorRepository extends CrudRepository<Director, Integer>, PagingAndSortingRepository<Director, Integer> {

    Director findByDirectorId(String productId);

    @Query("select count(*) from Director p where p.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select p from Director p where p.address.city = 'Warszawa'")
    Iterable<Director> getDirectorFromCity();
}