package com.projekt.spring.controllers;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Genres;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.GenresService;
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
public class GenreController {

    @Autowired
    private GenresService genresService;


    /**
     * List all genres.
     *
     */
    @RequestMapping(value = "/genres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genres> list(Model model) {
        return genresService.listAllGenres();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/genres", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genres> redirect(Model model) {
        return genresService.listAllGenres();
    }

    @RequestMapping(value = "/genres/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genres> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return genresService.listAllGenresPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific genre by its id.
     *
     * @return
     */
    @RequestMapping(value = "/genre/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Genres> getByPublicId(@PathVariable("id") Integer publicId) {
        return genresService.getGenresById(publicId);
    }

    /**
     * View a specific genre by its id.
     *
     * @return
     */
    @RequestMapping(value = "/genre", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Genres> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return genresService.getGenresById(publicId);
    }

    /**
     * Save genre to database.
     *
     */
    @RequestMapping(value = "/genre", method = RequestMethod.POST)
    public ResponseEntity<Genres> create(@RequestBody @Valid @NotNull Genres genre) {
        genre.setGenreId(UUID.randomUUID().toString());
        genresService.saveGenres(genre);
        return ResponseEntity.ok().body(genre);
    }


    /**
     * Edit genre in database.
     *
     */
    @RequestMapping(value = "/genre", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Genres genre) {
        if(!genresService.checkIfExist(genre.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            genresService.saveGenres(genre);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete genre by its id.
     *
     */
    @RequestMapping(value = "/genre/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        genresService.deleteGenres(id);
        return new RedirectView("/api/genre", true);
    }



}
