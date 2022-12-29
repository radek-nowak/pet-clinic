package com.springapp.petclinic.service;

import java.util.*;

public abstract class CrudServiceMap<T, ID> implements CrudService<T, ID> {

    Map<ID, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public <S extends T> S save(ID id, S entity) {
        map.put(id, entity);
        return entity;
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
