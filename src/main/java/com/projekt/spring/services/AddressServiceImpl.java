package com.projekt.spring.services;

import com.projekt.spring.entities.Address;
import com.projekt.spring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Iterable<Address> listAllAdresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Address saveAddress(Address product) {
        return null;
    }

    @Override
    public void deleteAddress(Integer id) {

    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return null;
    }
}
