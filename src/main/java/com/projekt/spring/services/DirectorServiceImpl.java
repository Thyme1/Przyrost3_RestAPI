package com.projekt.spring.services;

import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Director service implement.
 */
@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private com.projekt.spring.repositories.DirectorRepository directorRepository;



    @Override
    public Iterable<Director> listAllDirectors() {
        return directorRepository.findAll();
    }


    @Override
    public Optional<Director> getDirectorById(Integer id) {
        return directorRepository.findById(id);
    }

    @Override
    public Director saveDirector(Director product) {
        return directorRepository.save(product);
    }

    @Override
    public void deleteDirector(Integer id) {
        directorRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (directorRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


    @Override
    public Iterable<Director> listAllDirectorsPaging(Integer pageNr, Integer howManyOnPage) {
        return directorRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Director> getDirectorFromCity() {
        return directorRepository.getDirectorFromCity();
    }


}