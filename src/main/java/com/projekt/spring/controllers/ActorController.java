package com.projekt.spring.controllers;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

/**
 * Product controller.
 */
@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    private ActorService actorService;


    /**
     * List all products.
     *
     */
    @RequestMapping(value = "/actors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actors> list(Model model) {
        return actorService.listAllActors();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/actors", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actors> redirect(Model model) {
        return actorService.listAllActors();
    }

    @RequestMapping(value = "/actors/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actors> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return actorService.listAllActorsPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific actor by its id.
     *
     * @return
     */
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actors> getByPublicId(@PathVariable("id") Integer publicId) {
        return actorService.getActorById(publicId);
    }

    /**
     * View a specific actor by its id.
     *
     * @return
     */
    @RequestMapping(value = "/actor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actors> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return actorService.getActorById(publicId);
    }

    /**
     * Save actor to database.
     *
     */
    @RequestMapping(value = "/actor", method = RequestMethod.POST)
    public ResponseEntity<Actors> create(@RequestBody @Valid @NotNull Actors actor) {
        actor.setActorID(UUID.randomUUID().toString());
        actorService.saveActor(actor);
        return ResponseEntity.ok().body(actor);
    }


    /**
     * Edit actor in database.
     *
     */
    @RequestMapping(value = "/actor", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Actors actor) {
        if(!actorService.checkIfExist(actor.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            actorService.saveActor(actor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete actor by its id.
     *
     */
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        actorService.deleteActor(id);
        return new RedirectView("/api/actor", true);
    }


    @RequestMapping(value = "/actor/salary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actors> getHighestSalaryActor(Integer salary) {
        return actorService.getHighestSalary(salary);
    }




}
