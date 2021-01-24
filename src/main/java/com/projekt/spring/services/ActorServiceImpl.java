package com.projekt.spring.services;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.repositories.ProductRepository;
import com.projekt.spring.entities.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Product service implement.
 */
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private Actor productRepository;



    @Override
    public Iterable<Actors> listAllActors() {
        return null;
    }

    @Override
    public Optional<Actors> getActorById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Actors saveActor(Actors product) {
        return null;
    }

    @Override
    public void deleteActor(Integer id) {

    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (productRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Actors> listAllActorsPaging(Integer pageNr, Integer howManyOnPage) {
        return null;
    }


}