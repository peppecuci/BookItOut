package com.bruxelles.bookitout.mappers;

import com.bruxelles.bookitout.models.dtos.ReservationDto;
import com.bruxelles.bookitout.models.entities.Reservation;
import com.bruxelles.bookitout.models.forms.ReservationForm;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation toEntity(ReservationForm form){

        if(form == null)
            return null;

        Reservation reservation = new Reservation();

        reservation.setDateOfReservation(form.getDateOfReservation());
        reservation.setHourOfReservation(form.getHourOfReservation());
        reservation.setSpecialRequest(form.getSpecialRequest());

        return reservation;
    }

    public ReservationDto toDto (Reservation entity) {

        if(entity == null)
            return  null;

        return ReservationDto.builder()
                .id(entity.getId())
                .dateOfReservation(entity.getDateOfReservation())
                .hourOfReservation(entity.getHourOfReservation())
                .specialRequest(entity.getSpecialRequest())
                .build();

    }

}
