package com.springapp.petclinic.service.map;

import com.springapp.petclinic.model.Vet;
import com.springapp.petclinic.service.VetService;

import java.util.Optional;
import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Vet> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public <S extends Vet> S save(S entity) {
        return super.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Optional<Vet> findByName(String name) {
        Vet vet = map.values().stream()
                .filter(v -> v.getFirstName().equals(name))
                .findFirst().orElse(null);
        return Optional.ofNullable(vet);
    }

    @Override
    public Optional<Vet> findByLastName(String name) {
        Vet vet = map.values().stream()
                .filter(v -> v.getLastName().equals(name))
                .findFirst().orElse(null);
        return Optional.ofNullable(vet);
    }
}
