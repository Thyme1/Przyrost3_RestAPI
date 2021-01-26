package com.projekt.spring.controllers;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Address;
import com.projekt.spring.services.ActorService;
import com.projekt.spring.services.AddressService;
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
public class AddressController {

    @Autowired
    private AddressService addressService;


    /**
     * List all products.
     *
     */
    @RequestMapping(value = "/addresses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> list(Model model) {
        return addressService.listAllAdresses();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/addresses", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> redirect(Model model) {
        return addressService.listAllAdresses();
    }




    /**
     * View a specific product by its id.
     *
     * @return
     */
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Address> getByPublicId(@PathVariable("id") Integer publicId) {
        return addressService.getAddressById(publicId);
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */
    @RequestMapping(value = "/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Address> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return addressService.getAddressById(publicId);
    }

    /**
     * Save product to database.
     *
     */
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<Address> create(@RequestBody @Valid @NotNull Address address) {
        address.setAddressId(UUID.randomUUID().toString());
        addressService.saveAddress(address);
        return ResponseEntity.ok().body(address);
    }


    /**
     * Edit product in database.
     *
     */
    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Address address) {
        if(!addressService.checkIfExist(address.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            addressService.saveAddress(address);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        addressService.deleteAddress(id);
        return new RedirectView("/api/address", true);
    }


    @RequestMapping(value = "/address/smallest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> getHighestSalaryActor(Integer number) {
        return addressService.getSmallestHouseNr(number);
    }

}
