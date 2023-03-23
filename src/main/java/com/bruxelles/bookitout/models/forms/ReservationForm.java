package com.bruxelles.bookitout.models.forms;

import com.bruxelles.bookitout.enums.ServiceHourOptions;
import lombok.Data;

import java.text.DateFormat;

@Data
public class ReservationForm {

    private DateFormat dateOfReservation;
    private ServiceHourOptions hourOfReservation;
    private String specialRequest;

}
