package com.bruxelles.bookitout.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class ReservationDto {

    private Long id;
    private Date reservationDateTime;
    private String specialRequest;

}
