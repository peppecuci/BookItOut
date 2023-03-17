package com.bruxelles.bookitout.services.implementations;

import com.bruxelles.bookitout.mappers.UzerMapper;
import com.bruxelles.bookitout.models.dtos.UzerDto;
import com.bruxelles.bookitout.models.entities.Uzer;
import com.bruxelles.bookitout.models.forms.UzerForm;
import com.bruxelles.bookitout.repositories.UzerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UzerServiceImpl implements UserDetailsService {

    private final UzerRepository uzerRepository;
    private final UzerMapper uzerMapper;

    public UzerServiceImpl(UzerRepository uzerRepository, UzerMapper uzerMapper) {
        this.uzerRepository = uzerRepository;
        this.uzerMapper = uzerMapper;
    }

    public UzerDto create(UzerForm toInsert) {

        if(toInsert == null) {
            throw new IllegalArgumentException("user to insert can't be null");
        }
        System.out.println(toInsert);
        Uzer uzer = uzerMapper.toEntity(toInsert);
        //todo addressRepository.save(client.getAddress());
        return uzerMapper.toDto(uzerRepository.save(uzer));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return uzerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found."));
    }



}
