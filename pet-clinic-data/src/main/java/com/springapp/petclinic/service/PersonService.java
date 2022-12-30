package com.springapp.petclinic.service;

import com.springapp.petclinic.model.Person;

import java.util.Optional;

public interface PersonService<T extends Person, ID> extends CrudService<T, ID> {

    // TODO: refactor as default methods.
    Optional<T> findByName(String name);

    Optional<T> findByLastName(String name);
}
