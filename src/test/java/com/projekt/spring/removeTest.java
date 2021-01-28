package com.projekt.spring;


import com.projekt.spring.controllers.IndexController;
import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Genres;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.ActorServiceImpl;
import com.projekt.spring.services.GenresService;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class removeTest {
    @Autowired
    GenresService genresService;

    @Autowired
    IndexController indexController;

    @Test
    public void removingTest() {


        indexController.forTesting();
        Iterable<Genres> list=genresService.listAllGenres();
        List<Genres> genresList=new ArrayList<>();
        for (Genres genres : list) {
            genresList.add(genres);
        }
        Assert.assertEquals(1, genresList.size());

        genresService.deleteGenres(3);

        Iterable<Genres> list3=genresService.listAllGenres();
        genresList.clear();
        for (Genres computer : list3) {
            genresList.add(computer);
        }

        Assert.assertEquals(0, genresList.size());


    }
}

