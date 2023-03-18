package com.bruxelles.bookitout.services.implementations;

import com.bruxelles.bookitout.exceptions.ElementNotFoundException;
import com.bruxelles.bookitout.mappers.UserMapper;
import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.entities.User;
import com.bruxelles.bookitout.models.forms.UserForm;
import com.bruxelles.bookitout.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto create(UserForm toInsert) {

        if(toInsert == null) {
            throw new IllegalArgumentException("user to insert can't be null");
        }
        System.out.println(toInsert);
        User user = userMapper.toEntity(toInsert);
        //todo addressRepository.save(client.getAddress());
        return userMapper.toDto(userRepository.save(user));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found."));
    }


    public UserDto getOne(Long id) {
        if(id == null)
            throw new IllegalArgumentException("id cannot be null");
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(User.class, id)));
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto update(UserForm toUpdate, Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(User.class, id));

        //todo add Address address = new Address;

        if(toUpdate.getName() != null)
            user.setName(toUpdate.getName());
        if(toUpdate.getLastname() != null)
            user.setLastname(toUpdate.getLastname());
        if(toUpdate.getMail() != null)
            user.setMail(toUpdate.getMail());
        if(toUpdate.getUsername() != null)
            user.setUsername(toUpdate.getUsername());

        user = userRepository.save(user);

        return userMapper.toDto(user);
    }

    public void delete(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(User.class, id));

        userRepository.delete(user);

    }
}