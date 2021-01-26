package com.projekt.spring.repositories;


import com.projekt.spring.entities.Actors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import java.util.Optional;

public interface ActorRepository extends CrudRepository<Actors, Integer>, PagingAndSortingRepository<Actors, Integer> {

    Actors findByActorID(String actorId);

    @Query("select count(*) from Actors p where p.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("SELECT c FROM Actors c WHERE c.salary = (select max(salary) from c)")
    Iterable<Actors> getHighestSalary(Integer salary);



}