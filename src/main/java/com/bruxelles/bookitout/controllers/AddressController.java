package com.bruxelles.bookitout.controllers;

import com.bruxelles.bookitout.models.dtos.AddressDto;
import com.bruxelles.bookitout.models.forms.AddressForm;
import com.bruxelles.bookitout.services.implementations.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;


    public AddressController(AddressService service) {
        this.service = service;
    }

    //CREATE
    //Is that method necessary? Do we need to have the possibility to add an address, or we just let the user add the address when he/she register as user?
    @PostMapping("/register")
    public AddressDto create(@RequestBody AddressForm form){
        return service.create(form);
    }

    //READ
    @GetMapping("/{id:[0-9]+}")
    public AddressDto getOne(@PathVariable Long id){

        return service.getOne(id);

    }

    @GetMapping("/all")
    public List<AddressDto> getAll(){

        return service.getAll();

    }

    @PatchMapping("/{id:[0-9]+}")
    public AddressDto update(@RequestBody AddressForm form,@PathVariable Long id){

        return service.update(form, id);

    }

    @DeleteMapping("{id:[0-9]+}")
    public void delete(@PathVariable Long id){

        service.delete(id);

    }


}
