package com.springapp.petclinic.service;

import com.springapp.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    public <S extends T> S save(S entity) {
        Optional<S> optionalS= Optional.ofNullable(entity);
        if (optionalS.isEmpty()) {
            throw new RuntimeException("ERROR: Object can not be null!");
        }
        map.put(optionalS.get().getId(), entity);
        return optionalS.get();
    }

    public void deleteById(ID id) {
        map.remove(id);
    }
}
