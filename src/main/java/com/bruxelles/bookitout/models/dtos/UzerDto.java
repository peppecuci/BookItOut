package com.bruxelles.bookitout.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UzerDto {

    private Long uzerId;
    private String name;
    private String lastname;
    private String mail;
    private String username;
    private AddressDto addressDto;

}
