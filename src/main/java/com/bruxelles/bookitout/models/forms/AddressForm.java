package com.bruxelles.bookitout.models.forms;

import lombok.Data;

@Data
public class AddressForm {

    private String num;
    private String street;
    private int zipCode;
    private String city;

}
