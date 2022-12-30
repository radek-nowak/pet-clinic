package com.springapp.petclinic.bootstrap;

import com.springapp.petclinic.model.Owner;
import com.springapp.petclinic.model.Pet;
import com.springapp.petclinic.model.Vet;
import com.springapp.petclinic.service.OwnerService;
import com.springapp.petclinic.service.PetService;
import com.springapp.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService<Pet, Long> petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService<Pet, Long> petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("A");

        Owner owner2 = new Owner();
        owner2.setFirstName("Johnny");
        owner2.setLastName("B");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Saving owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jimmy");
        vet1.setLastName("C");

        vetService.save(vet1);

        System.out.println("Saving vets...");

        Pet pet1 = new Pet();
        pet1.setName("Pet's name");
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.of(2020,12,21));

        petService.save(pet1);

        System.out.println("Saving pets...");
    }
}
