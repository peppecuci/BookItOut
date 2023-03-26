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

        reservation.setReservationDateTime(form.getReservationDateTime());
        reservation.setSpecialRequest(form.getSpecialRequest());

        return reservation;
    }

    public ReservationDto toDto (Reservation entity) {

        if(entity == null)
            return  null;

        return ReservationDto.builder()
                .id(entity.getId())
                .reservationDateTime(entity.getReservationDateTime())
                .specialRequest(entity.getSpecialRequest())
                .build();

    }

}
