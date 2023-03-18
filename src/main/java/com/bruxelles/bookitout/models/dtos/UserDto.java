package com.bruxelles.bookitout.models.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String lastname;
    private String mail;
    private String username;
    //private AddressDto addressDto;

}
