package com.springapp.petclinic.model;

public class Vet extends Person{
    private VetSpeciality speciality;

    public VetSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(VetSpeciality speciality) {
        this.speciality = speciality;
    }
}
