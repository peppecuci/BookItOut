package com.bruxelles.bookitout.mappers;

import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.entities.User;
import com.bruxelles.bookitout.models.forms.UserForm;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final AddressMapper addressMapper;

    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public User toEntity(UserForm userForm){

        if(userForm == null)
            return null;

        User user = new User();
        //TODO Address address = new Address();

        user.setName(userForm.getName());
        user.setLastname(userForm.getLastname());
        user.setMail(userForm.getMail());
        user.setUsername(userForm.getUsername());
        System.out.println(user.getUsername());

        return user;
    }

    public UserDto toDto(User entity){

        if(entity == null)
            return null;

        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .mail(entity.getMail())
                .username(entity.getUsername()) //todo check postman http request GETONE (username == null), why is that???
                //.addressDto(addressMapper.toDto(entity.getAddress()))
                .build();

    }

}
