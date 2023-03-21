package com.bruxelles.bookitout.mappers;

import com.bruxelles.bookitout.models.dtos.AddressDto;
import com.bruxelles.bookitout.models.entities.Address;
import com.bruxelles.bookitout.models.forms.AddressForm;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(AddressForm form){

        if(form == null)
            return null;

        Address address = new Address();

        address.setNum(form.getNum());
        address.setStreet(form.getStreet());
        address.setZipCode(form.getZipCode());
        address.setCity(form.getCity());

        return address;

    }

    public AddressDto toDto(Address entity){

        if(entity == null)
            return null;

        return AddressDto.builder()
                .num(entity.getNum())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .city(entity.getCity())
                .build();

    }
}
