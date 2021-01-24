package com.projekt.spring.services;

import com.projekt.spring.entities.Director;

import java.util.Optional;

public interface DirectorService {

    Iterable<Director> listAllDirectors();

    Optional<Director> getDirectorById(Integer id);

    Director saveDirector(Director product);

    void deleteDirector(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Director> listAllDirectorsPaging(Integer pageNr, Integer howManyOnPage);



}
