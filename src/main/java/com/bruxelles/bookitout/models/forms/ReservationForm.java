package com.bruxelles.bookitout.models.forms;

import lombok.Data;

import java.sql.Date;

@Data
public class ReservationForm {

    private Date reservationDateTime;
    private String specialRequest;

}
