package com.projekt.spring.services;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.repositories.ActorRepository;
import com.projekt.spring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Actor service implement.
 */
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private AddressRepository addressRepository;



    @Override
    public Iterable<Actors> listAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Iterable<Actors> getActorById(Integer id) {
        return actorRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public Actors saveActor(Actors actor) {
        return actorRepository.save(actor);
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

    @Override
    public Iterable<Actors> getHighestSalary(Integer salary) {
        return actorRepository.getHighestSalary(salary);
    }


}