package com.bruxelles.bookitout.controllers;

import com.bruxelles.bookitout.models.forms.UzerForm;
import com.bruxelles.bookitout.services.implementations.UzerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/user")
@RestController
public class UzerController {

    private final UzerServiceImpl uzerService;


    public UzerController(UzerServiceImpl uzerService) {
        this.uzerService = uzerService;
    }

    //CRUD

    //CREATE
    @PostMapping("/register")
    public void createUzer(@RequestBody UzerForm uzerForm) {
        uzerService.create(uzerForm);
    }
    //READ

    //UPDATE

    //DELETE

}
