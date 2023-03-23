package com.bruxelles.bookitout.models.entities;

import com.bruxelles.bookitout.enums.ServiceHourOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_reservation")
    private DateFormat dateOfReservation;

    @Column(name = "hour_of_reservation")
    private ServiceHourOptions hourOfReservation;

    //THAT VARIABLE INDICATES IF THE CUSTOMER HAS ANY SPECIAL REQUEST, FOR EXAMPLE "A QUIET TABLE FOR A BUSINESS DINNER"
    @Column(name = "special_request")
    private String specialRequest;



}
