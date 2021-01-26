package com.projekt.spring.controllers;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Director;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.DirectorService;
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
public class DirectorController {

    @Autowired
    private DirectorService directorService;


    /**
     * List all products.
     *
     */
    @RequestMapping(value = "/directors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> list(Model model) {
        return directorService.listAllDirectors();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/directors", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> redirect(Model model) {
        return directorService.listAllDirectors();
    }

    @RequestMapping(value = "/directors/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return directorService.listAllDirectorsPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific product by its id.
     *
     * @return
     */
    @RequestMapping(value = "/director/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> getByPublicId(@PathVariable("id") Integer publicId) {
        return directorService.getDirectorById(publicId);
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */
    @RequestMapping(value = "/director", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return directorService.getDirectorById(publicId);
    }

    /**
     * Save product to database.
     *
     */
    @RequestMapping(value = "/director", method = RequestMethod.POST)
    public ResponseEntity<Director> create(@RequestBody @Valid @NotNull Director director) {
        director.setDirectorId(UUID.randomUUID().toString());
        directorService.saveDirector(director);
        return ResponseEntity.ok().body(director);
    }


    /**
     * Edit product in database.
     *
     */
    @RequestMapping(value = "/director", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Director director) {
        if(!directorService.checkIfExist(director.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            directorService.saveDirector(director);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @RequestMapping(value = "/director/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        directorService.deleteDirector(id);
        return new RedirectView("/api/director", true);
    }

    @RequestMapping(value = "/director/city", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Director> getHighestSalaryActor() {
        return directorService.getDirectorFromCity();
    }

}
