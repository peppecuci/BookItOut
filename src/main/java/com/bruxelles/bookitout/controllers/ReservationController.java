package com.bruxelles.bookitout.controllers;

import com.bruxelles.bookitout.models.dtos.ReservationDto;
import com.bruxelles.bookitout.models.forms.ReservationForm;
import com.bruxelles.bookitout.services.implementations.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("/reservation")
@RestController
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping("register")
    public ReservationDto register(@RequestBody ReservationForm form){
        return service.register(form);
    }

    @GetMapping("/{id:[0-9]+}")
    public ReservationDto getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping("/all")
    public List<ReservationDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/all-by-date/{date}")
    public List<ReservationDto> getAllByDateOfReservation(@PathVariable Date date) {
        return service.getAllByReservationDateTime(date);
    }

    //TODO not working. 403 error.
    @PatchMapping("{id:[0:9]+1}")
    public ReservationDto update(@RequestBody ReservationForm form, @PathVariable Long id){
        return service.update(form, id);
    }

    @DeleteMapping("{id:[0-9]+}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
