package com.bruxelles.bookitout.models.forms;

import lombok.Data;


@Data
public class UserCreateForm {

    private String name;
    private String lastname;
    private String mail;
    private String username;
    private String password;
    private AddressForm address;

}
