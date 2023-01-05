package com.springapp.petclinic.service.map;

import com.springapp.petclinic.model.BaseEntity;
import com.springapp.petclinic.service.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    public <S extends T> S save(S entity) {
        Optional<S> optionalS = Optional.ofNullable(entity);
        entity = optionalS.orElseThrow(() -> new RuntimeException("ERROR: Object can not be null."));
        entity.setId(nextIndex());
        map.put(entity.getId(), entity);
        return entity;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long nextIndex() {
        Long nextIndex;
        try {
            nextIndex = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextIndex = 1L;
        }
        return nextIndex;
    }
}
