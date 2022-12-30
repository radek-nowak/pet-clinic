package com.springapp.petclinic.service.map;

import com.springapp.petclinic.model.Owner;
import com.springapp.petclinic.service.OwnerService;

import java.util.Optional;
import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Owner> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public <S extends Owner> S save(S entity) {
        return super.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Optional<Owner> findByName(String name) {
        Owner owner = map.values().stream()
                .filter(t -> t.getFirstName().equals(name))
                .findFirst().orElse(null);
        return Optional.ofNullable(owner);
    }

    @Override
    public Optional<Owner> findByLastName(String name) {
        Owner owner = map.values().stream()
                .filter(t -> t.getLastName().equals(name))
                .findFirst().orElse(null);
        return Optional.ofNullable(owner);

    }
}
