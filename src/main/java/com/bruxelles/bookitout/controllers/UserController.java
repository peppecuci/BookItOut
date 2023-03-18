package com.bruxelles.bookitout.controllers;

import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.forms.UserForm;
import com.bruxelles.bookitout.services.implementations.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo @CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //CRUD

    //CREATE
    @PostMapping("/register")
    public void createUzer(@RequestBody UserForm uzerForm) {
        userService.create(uzerForm);
    }

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
    public UserDto update(@RequestBody UserForm toUpdate, @PathVariable Long id) {
        return userService.update(toUpdate, id);
    }


    //DELETE
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
