package com.bruxelles.bookitout.services.implementations;

import com.bruxelles.bookitout.exceptions.ElementNotFoundException;
import com.bruxelles.bookitout.mappers.ReservationMapper;
import com.bruxelles.bookitout.models.dtos.ReservationDto;
import com.bruxelles.bookitout.models.entities.Reservation;
import com.bruxelles.bookitout.models.forms.ReservationForm;
import com.bruxelles.bookitout.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;

    public ReservationService(ReservationRepository repository, ReservationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ReservationDto register(ReservationForm toInsert){

        if(toInsert == null)
            throw new IllegalArgumentException("Reservation to insert cannot be null");

        Reservation reservation = mapper.toEntity(toInsert);

        return mapper.toDto(repository.save(reservation));

    }

    public ReservationDto getOne(Long id){

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Reservation.class, id)));

    }

    public List<ReservationDto> getAll(){

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();

    }

    //Method that give all the reservations of a specific date.
    //TODO method don't working. To fix.
    public List<ReservationDto> getAllByReservationDateTime(Date reservationDateTime) {
        if(reservationDateTime == null)
            throw new IllegalArgumentException("date of reservation cannot be null");

        return repository.findReservationByReservationDateTime(reservationDateTime)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    //TODO implement the method
    /*public List<ReservationDto> getAllByCustomerName(String firstname, String username) {

        if(firstname == null || username == null)
            throw new IllegalArgumentException("firstname or username cannot be null");

        return repository.

    }*/

    public ReservationDto update(ReservationForm toUpdate, Long id) {

        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Reservation.class, id));

        if(toUpdate.getReservationDateTime() != null)
            reservation.setReservationDateTime(toUpdate.getReservationDateTime());
        if(toUpdate.getReservationDateTime() != null)
            reservation.setReservationDateTime(toUpdate.getReservationDateTime());
        if(toUpdate.getSpecialRequest() != null)
            reservation.setSpecialRequest(toUpdate.getSpecialRequest());

        reservation = repository.save(reservation);

        return mapper.toDto(reservation);

    }

    public void delete(Long id) {

        if(id == null)
            throw new IllegalArgumentException("id cannot be null");

        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Reservation.class, id));

        repository.delete(reservation);

    }

}
