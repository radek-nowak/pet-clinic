package com.springapp.petclinic.service;

import com.springapp.petclinic.model.Owner;
import com.springapp.petclinic.model.Pet;

import java.util.Optional;

public interface PetService<T extends Pet, ID extends Long> extends CrudService<T, ID> {

    Optional<T> findByName(String name);

    Optional<T> findByOwner(Owner owner);
}
