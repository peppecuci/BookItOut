package com.bruxelles.bookitout.controllers;

import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.forms.UserCreateForm;
import com.bruxelles.bookitout.security.auth.AuthenticationRequest;
import com.bruxelles.bookitout.security.auth.AuthenticationResponse;
import com.bruxelles.bookitout.security.auth.AuthenticationService;
import com.bruxelles.bookitout.services.implementations.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo @CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService, AuthenticationService service) {
        this.userService = userService;
        this.service = service;
    }
    private final AuthenticationService service;
    //CRUD
    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserCreateForm request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/log-in")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    //CREATE
    /*@PostMapping("/register")
    public void createUser(@RequestBody UserCreateForm userForm) {
        userService.create(userForm);
    }*/

    //READ
    @GetMapping("/{id:[0-9]+}")
    public UserDto getOne(@PathVariable Long id){
        return userService.getOne(id);
    }

    @GetMapping("/all")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    //UPDATE
    @PatchMapping("/{id:[0-9]+}")
    public UserDto update(@RequestBody UserCreateForm toUpdate, @PathVariable Long id) {
        return userService.update(toUpdate, id);
    }


    //DELETE
    //TODO Method currently not working. Need to fix it
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    //LOGIN


}
