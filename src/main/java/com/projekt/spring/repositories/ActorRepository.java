package com.projekt.spring.repositories;


import com.projekt.spring.entities.Actors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface ActorRepository extends CrudRepository<Actors, Integer>, PagingAndSortingRepository<Actors, Integer> {

    Actors findByActorID(String actorId);

    @Query("select count(*) from Actors p where p.id = ?1")
    Integer checkIfExist(Integer id);



}