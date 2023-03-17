package com.bruxelles.bookitout.mappers;

import com.bruxelles.bookitout.models.dtos.UzerDto;
import com.bruxelles.bookitout.models.entities.Uzer;
import com.bruxelles.bookitout.models.forms.UzerForm;
import org.springframework.stereotype.Component;

@Component
public class UzerMapper {

    private final AddressMapper addressMapper;

    public UzerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Uzer toEntity(UzerForm uzerForm){

        if(uzerForm == null)
            return null;

        Uzer uzer = new Uzer();
        //TODO Address address = new Address();

        uzer.setName(uzerForm.getName());
        uzer.setLastname(uzerForm.getLastname());
        uzer.setMail(uzerForm.getMail());
        uzer.setMail(uzerForm.getMail());
        uzer.setUsername(uzer.getUsername());

        return uzer;
    }

    public UzerDto toDto(Uzer entity){

        if(entity == null)
            return null;

        return UzerDto.builder()
                .uzerId(entity.getUzerId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .mail(entity.getMail())
                .username(entity.getUsername())
                //.addressDto(addressMapper.toDto(entity.getAddress()))
                .build();

    }

}
