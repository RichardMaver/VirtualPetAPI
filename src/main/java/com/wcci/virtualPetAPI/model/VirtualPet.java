package com.wcci.virtualPetAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VirtualPet {
    

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String petType;

    @Column
    private String petName;

    @Column
    private String petDescription;

    @Column
    private String hunger;

    @Column
    private String thirst;

    @Column
    private String boredom;

    public long getId() {
        return id;
    }

    public String getPetType() {
        return petType;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public String getHunger() {
        return hunger;
    }

    public String getThirst() {
        return thirst;
    }

    public String getBoredom() {
        return boredom;
    }

    public VirtualPet(){
        
    }

    public VirtualPet(String petType, String petName, String petDescription, String hunger, String thirst,
            String boredom) {
        this.petType = petType;
        this.petName = petName;
        this.petDescription = petDescription;
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public void setHunger(String hunger) {
        this.hunger = hunger;
    }

    public void setThirst(String thirst) {
        this.thirst = thirst;
    }

    public void setBoredom(String boredom) {
        this.boredom = boredom;
    }

}
