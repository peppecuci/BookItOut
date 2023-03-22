package com.bruxelles.bookitout.models.dtos;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String mail;
    private String username;
    private String password;
    private AddressDto address;

}
