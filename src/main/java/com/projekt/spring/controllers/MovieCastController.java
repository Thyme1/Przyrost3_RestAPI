package com.projekt.spring.controllers;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.MovieCast;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.MovieCastService;
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
public class MovieCastController {

    @Autowired
    private MovieCastService movieCastService;


    /**
     * List all movieCasts.
     *
     */
    @RequestMapping(value = "/movieCasts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MovieCast> list(Model model) {
        return movieCastService.listAllMovieCasts();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/movieCasts", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MovieCast> redirect(Model model) {
        return movieCastService.listAllMovieCasts();
    }




    /**
     * View a specific movieCast by its id.
     *
     * @return
     */
    @RequestMapping(value = "/movieCast/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MovieCast> getByPublicId(@PathVariable("id") Integer publicId) {
        return movieCastService.getMovieCastById(publicId);
    }

    /**
     * View a specific movieCast by its id.
     *
     * @return
     */
    @RequestMapping(value = "/movieCast", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MovieCast> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return movieCastService.getMovieCastById(publicId);
    }

    /**
     * Save movieCast to database.
     *
     */
    @RequestMapping(value = "/movieCast", method = RequestMethod.POST)
    public ResponseEntity<MovieCast> create(@RequestBody @Valid @NotNull MovieCast actor) {
        actor.setMovieCastId(UUID.randomUUID().toString());
        movieCastService.saveMovieCast(actor);
        return ResponseEntity.ok().body(actor);
    }


    /**
     * Edit movieCast in database.
     *
     */
    @RequestMapping(value = "/movieCast", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull MovieCast actor) {
        if(!movieCastService.checkIfExist(actor.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            movieCastService.saveMovieCast(actor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @RequestMapping(value = "/movieCast/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        movieCastService.deleteMovieCast(id);
        return new RedirectView("/api/movieCast", true);
    }

}
