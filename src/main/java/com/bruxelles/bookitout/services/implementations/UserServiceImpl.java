package com.bruxelles.bookitout.services.implementations;

import com.bruxelles.bookitout.exceptions.ElementNotFoundException;
import com.bruxelles.bookitout.mappers.UserMapper;
import com.bruxelles.bookitout.models.dtos.UserDto;
import com.bruxelles.bookitout.models.entities.Address;
import com.bruxelles.bookitout.models.entities.User;
import com.bruxelles.bookitout.models.forms.UserCreateForm;
import com.bruxelles.bookitout.repositories.AddressRepository;
import com.bruxelles.bookitout.repositories.UserRepository;
import com.bruxelles.bookitout.security.token.Token;
import com.bruxelles.bookitout.security.token.TokenRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressRepository addressRepository;
    private final TokenRepository tokenRepository;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, AddressRepository addressRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressRepository = addressRepository;
        this.tokenRepository = tokenRepository;
    }

    public UserDto create(UserCreateForm toInsert) {

        if(toInsert == null) {
            throw new IllegalArgumentException("user to insert can't be null");
        }

        User user = userMapper.toEntity(toInsert);

        addressRepository.save(user.getAddress());

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

    public UserDto update(UserCreateForm toUpdate, Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(User.class, id));

        Address address = new Address();

        if(toUpdate.getFirstname() != null)
            user.setFirstname(toUpdate.getFirstname());
        if(toUpdate.getLastname() != null)
            user.setLastname(toUpdate.getLastname());
        if(toUpdate.getMail() != null)
            user.setMail(toUpdate.getMail());
        if(toUpdate.getUsername() != null)
            user.setUsername(toUpdate.getUsername());

        if(user.getAddress().getNum() != null)
            user.getAddress().setNum(toUpdate.getAddress().getNum());
        if(user.getAddress().getStreet() != null)
            user.getAddress().setStreet(toUpdate.getAddress().getStreet());
        if(user.getAddress().getZipCode() != null)
            user.getAddress().setZipCode(toUpdate.getAddress().getZipCode());
        if(user.getAddress().getCity() != null)
            user.getAddress().setCity(toUpdate.getAddress().getCity());


        user = userRepository.save(user);
        addressRepository.save(address);

        return userMapper.toDto(user);
    }

    public UserDto disable(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow( ()-> new ElementNotFoundException(User.class, id) );

        user.setEnabled(false);

        userRepository.save(user);

        return userMapper.toDto(user);

    }

    public UserDto enable(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(User.class, id));

        user.setEnabled(true);
        userRepository.save(user);

        return userMapper.toDto(user);

    }

    public void delete(Long id) {

        List<Token> token = tokenRepository.findAllValidTokenByUser(id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(User.class, id));

        tokenRepository.deleteAll(token);

        userRepository.delete(user);


    }
}
