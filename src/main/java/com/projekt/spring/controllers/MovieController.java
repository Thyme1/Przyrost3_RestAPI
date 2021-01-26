package com.projekt.spring.controllers;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Director;
import com.projekt.spring.entities.Movie;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.MovieService;
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
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     * List all products.
     *
     */
    @RequestMapping(value = "/movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> list(Model model) {
        return movieService.listAllMovies();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/movies", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> redirect(Model model) {
        return movieService.listAllMovies();
    }

    @RequestMapping(value = "/movie/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return movieService.listAllMoviesPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific product by its id.
     *
     * @return
     */
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Movie> getByPublicId(@PathVariable("id") Integer publicId) {
        return movieService.getMovieById(publicId);
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */
    @RequestMapping(value = "/movie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Movie> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return movieService.getMovieById(publicId);
    }

    /**
     * Save product to database.
     *
     */
    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public ResponseEntity<Movie> create(@RequestBody @Valid @NotNull Movie movie) {
        movie.setId(Integer.valueOf(String.valueOf(UUID.randomUUID())));
        movieService.saveMovie(movie);
        return ResponseEntity.ok().body(movie);
    }


    /**
     * Edit product in database.
     *
     */
    @RequestMapping(value = "/movie", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Movie movie) {
        if(!movieService.checkIfExist(movie.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            movieService.saveMovie(movie);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        movieService.deleteMovie(id);
        return new RedirectView("/api/movie", true);
    }

    @RequestMapping(value = "/movie/longest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> getLongestMovie() {
        return movieService.getLongestMovie();
    }

}
