package com.projekt.spring.services;

import com.projekt.spring.entities.Address;

import java.util.Optional;

public interface AddressService {



        Iterable<Address> listAllAdresses();

        Optional<Address> getAddressById(Integer id);

        Address saveAddress(Address product);

        void deleteAddress(Integer id);

        Boolean checkIfExist(Integer id);




}
