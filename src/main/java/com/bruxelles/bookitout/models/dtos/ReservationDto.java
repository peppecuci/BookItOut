package com.bruxelles.bookitout.models.dtos;

import com.bruxelles.bookitout.enums.ServiceHourOptions;
import lombok.Builder;
import lombok.Data;

import java.text.DateFormat;

@Data
@Builder
public class ReservationDto {

    private Long id;
    private DateFormat dateOfReservation;
    private ServiceHourOptions hourOfReservation;
    private String specialRequest;

}
