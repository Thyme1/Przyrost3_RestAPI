package com.projekt.spring.services;


import com.projekt.spring.entities.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Actor service implement.
 */
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private com.projekt.spring.repositories.ActorRepository actorRepository;



    @Override
    public Iterable<Actors> listAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<Actors> getActorById(Integer id) {
        return actorRepository.findById(id);
    }

    @Override
    public Actors saveActor(Actors product) {
        return actorRepository.save(product);
    }

    @Override
    public void deleteActor(Integer id) {
        actorRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (actorRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Actors> listAllActorsPaging(Integer pageNr, Integer howManyOnPage) {
        return actorRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }


}