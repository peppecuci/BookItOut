package com.bruxelles.bookitout.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column(name = "reservation_date_time")
    private Date reservationDateTime;

    //THAT VARIABLE INDICATES IF THE CUSTOMER HAS ANY SPECIAL REQUEST, FOR EXAMPLE "A QUIET TABLE FOR A BUSINESS DINNER"
    @Column(name = "special_request")
    private String specialRequest;



}
