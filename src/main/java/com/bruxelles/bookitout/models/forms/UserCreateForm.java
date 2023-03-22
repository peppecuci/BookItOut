package com.bruxelles.bookitout.models.forms;

import com.bruxelles.bookitout.models.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateForm {

    private String firstname;
    private String lastname;
    private String mail;
    private String username;
    private String password;
    private Address address;
}
