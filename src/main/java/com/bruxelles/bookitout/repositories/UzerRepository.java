package com.bruxelles.bookitout.repositories;

import com.bruxelles.bookitout.models.entities.Uzer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UzerRepository extends CrudRepository<Uzer, Long> {

    Optional<Uzer> findByUsername(String username);
    //public List<Uzer> findAll();
}
