package com.bruxelles.bookitout.repositories;

import com.bruxelles.bookitout.models.dtos.AddressDto;
import com.bruxelles.bookitout.models.entities.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findAll();

}
