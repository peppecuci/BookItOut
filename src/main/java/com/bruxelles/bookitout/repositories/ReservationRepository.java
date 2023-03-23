package com.bruxelles.bookitout.repositories;

import com.bruxelles.bookitout.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.DateFormat;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationByDateOfReservation(DateFormat dateOfReservation);

}
