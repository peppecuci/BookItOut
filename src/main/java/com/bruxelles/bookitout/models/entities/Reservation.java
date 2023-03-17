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
    private Long reservationId;

    @Column(name = "dateOfReservation")
    private DateFormat dateOfReservation;

    @Column(name = "hourOfReservation")
    private ServiceHourOptions hourOfReservation;

    @Column(name = "special_request")
    private String specialRequest;



}
