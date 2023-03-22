package com.bruxelles.bookitout.mappers;

import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.entities.Address;
import com.bruxelles.bookitout.models.entities.User;
import com.bruxelles.bookitout.models.forms.UserCreateForm;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final AddressMapper addressMapper;

    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }


    public User toEntity(UserCreateForm form){

        if(form == null)
            return null;

        User user = new User();
        Address address = new Address();

        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
        user.setMail(form.getMail());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());

        address.setNum(form.getAddress().getNum());
        address.setStreet(form.getAddress().getStreet());
        address.setZipCode(form.getAddress().getZipCode());
        address.setCity(form.getAddress().getCity());

        user.setAddress(address);

        return user;
    }

    public UserDto toDto(User entity){

        if(entity == null)
            return null;

        return UserDto.builder()
                .id(entity.getId())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .mail(entity.getMail())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .address(addressMapper.toDto(entity.getAddress()))
                .build();

    }

}
