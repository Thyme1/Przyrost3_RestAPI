package com.projekt.spring.services;

import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Director;
import com.projekt.spring.entities.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Director service implement.
 */
@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private com.projekt.spring.repositories.GenresRepository genresRepository;



    @Override
    public Iterable<Genres> listAllGenres() {
        return genresRepository.findAll();
    }


    @Override
    public Optional<Genres> getGenresById(Integer id) {
        return genresRepository.findById(id);
    }

    @Override
    public Genres saveGenres(Genres product) {
        return genresRepository.save(product);
    }

    @Override
    public void deleteGenres(Integer id) {
        genresRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (genresRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


    @Override
    public Iterable<Genres> listAllGenresPaging(Integer pageNr, Integer howManyOnPage) {
        return genresRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }


}