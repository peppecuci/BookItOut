package com.bruxelles.bookitout.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String num;
    private String street;
    private int zipCode;
    private String city;

}
