package com.springapp.petclinic.service.map;

import com.springapp.petclinic.model.Owner;
import com.springapp.petclinic.model.Pet;
import com.springapp.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PetMapService<T extends Pet, ID extends Long> extends AbstractMapService<T, ID> implements PetService<T, ID> {

    @Override
    public Set<T> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return super.findById(id);
    }

    @Override
    public <S extends T> S save(S entity) {
        return super.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        super.deleteById(id);
    }

    @Override
    public Optional<T> findByName(String name) {
        T pet = map.values().stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
        return Optional.ofNullable(pet);
    }

    @Override
    public Optional<T> findByOwner(Owner owner) {
        T pet = map.values().stream()
                .filter(p -> p.getOwner().equals(owner))
                .findFirst().orElse(null);
        return Optional.ofNullable(pet);
    }
}
