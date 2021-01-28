package com.projekt.spring.services;


import com.projekt.spring.entities.Address;


public interface AddressService {


    Iterable<Address> listAllAdresses();

    Iterable<Address> getAddressById(Integer id);

    Address saveAddress(Address product);

    void deleteAddress(Integer id);

    Boolean checkIfExist(Integer id);


    Iterable<Address> getSmallestHouseNr(Integer number);
}
