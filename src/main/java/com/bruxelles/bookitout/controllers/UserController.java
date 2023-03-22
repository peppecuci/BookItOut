package com.bruxelles.bookitout.controllers;

import com.bruxelles.bookitout.models.dtos.TokenDto;
import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.forms.UserCreateForm;
import com.bruxelles.bookitout.models.forms.UserLoginForm;
import com.bruxelles.bookitout.services.implementations.UserServiceImpl;
import com.bruxelles.bookitout.utils.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo @CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public UserController(UserServiceImpl userService, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    //CRUD

    //CREATE
    @PostMapping("/register")
    public void createUser(@RequestBody UserCreateForm userForm) {
        userService.create(userForm);
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
    public UserDto update(@RequestBody UserCreateForm toUpdate, @PathVariable Long id) {
        return userService.update(toUpdate, id);
    }


    //DELETE
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    //LOGIN
    @PostMapping("/login")
    public TokenDto login(@RequestBody UserLoginForm form){

        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));


        return new TokenDto(jwtProvider.createToken(auth));

    }

}
