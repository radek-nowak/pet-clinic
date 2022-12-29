package com.springapp.petclinic.service;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    Optional<T> findById(ID id);

    <S extends T> S save(ID id, S entity);

    void deleteById(ID id);
}
