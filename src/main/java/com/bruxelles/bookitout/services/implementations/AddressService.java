package com.bruxelles.bookitout.services.implementations;

import com.bruxelles.bookitout.exceptions.ElementNotFoundException;
import com.bruxelles.bookitout.mappers.AddressMapper;
import com.bruxelles.bookitout.models.dtos.AddressDto;
import com.bruxelles.bookitout.models.entities.Address;
import com.bruxelles.bookitout.models.forms.AddressForm;
import com.bruxelles.bookitout.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressMapper mapper;
    private final AddressRepository repository;

    public AddressService(AddressMapper mapper, AddressRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    public AddressDto create(AddressForm toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("address cannot be null");

        Address address = mapper.toEntity(toInsert);

        return mapper.toDto(repository.save(address));

    }


    public AddressDto getOne(Long id) {
        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));
    }

    public List<AddressDto> getAll(){

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();

    }

    public AddressDto update(AddressForm form, Long id){

        Address address = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));

        if(form.getNum() != null)
            address.setNum(form.getNum());
        if(form.getStreet() != null)
            address.setStreet(form.getStreet());
        if(form.getZipCode() != null)
            address.setZipCode(form.getZipCode());
        if(form.getCity() != null)
            address.setCity(form.getCity());

        address = repository.save(address);

        return mapper.toDto(address);

    }

    public void delete(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        Address address = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Address.class, id));

        repository.delete(address);

    }
}
