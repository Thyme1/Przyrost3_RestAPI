package com.projekt.spring;


import com.projekt.spring.controllers.IndexController;
import com.projekt.spring.entities.Actors;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.ActorServiceImpl;
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
public class addTest {
    @Autowired
    ActorService actorService;

    @Autowired
    IndexController indexController;

    @Test
    public void addingTest()
    {
        indexController.forTesting();
        Iterable<Actors> list = actorService.listAllActors();
        List<Actors> actorsList = new ArrayList<>();

        for(Actors actor : list)
        {
            actorsList.add(actor);
        }

        Assert.assertEquals(1,actorsList.size());

        indexController.forTesting();
        Iterable<Actors> list2 = actorService.listAllActors();
        actorsList.clear();
        for(Actors actor : list2)
        {
            actorsList.add(actor);
        }
        Assert.assertEquals(2,actorsList.size());
    }
}
