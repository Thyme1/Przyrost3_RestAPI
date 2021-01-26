package com.projekt.spring.repositories;


import com.projekt.spring.entities.Actors;
import com.projekt.spring.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer> {

    Address findByAddressId(String productId);

    @Query("select count(*) from Address p where p.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("SELECT c FROM Address c WHERE c.housenr = (select min(housenr) from c)")
    Iterable<Address> getSmallestHouseNr(Integer housern);
}