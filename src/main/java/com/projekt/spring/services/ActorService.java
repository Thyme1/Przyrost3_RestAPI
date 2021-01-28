package com.projekt.spring.services;


import com.projekt.spring.entities.Actors;


public interface ActorService {

    Iterable<Actors> listAllActors();

    Iterable<Actors> getActorById(Integer id);

    Actors saveActor(Actors product);

    void deleteActor(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Actors> listAllActorsPaging(Integer pageNr, Integer howManyOnPage);


    Iterable<Actors> getHighestSalary(Integer salary);
}

