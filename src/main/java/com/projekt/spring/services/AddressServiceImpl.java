package com.projekt.spring.services;

import com.projekt.spring.entities.Address;

import com.projekt.spring.repositories.ActorRepository;
import com.projekt.spring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Iterable<Address> listAllAdresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address saveAddress(Address product) {
        return addressRepository.save(product);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);

    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (addressRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

}
