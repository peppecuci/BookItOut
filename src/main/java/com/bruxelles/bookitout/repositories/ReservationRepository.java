package com.bruxelles.bookitout.repositories;

import com.bruxelles.bookitout.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationByReservationDateTime(Date dateAndHourOfReservation);

}
