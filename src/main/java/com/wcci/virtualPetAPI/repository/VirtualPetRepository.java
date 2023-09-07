package com.wcci.virtualPetAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.wcci.virtualPetAPI.model.VirtualPet;

public interface VirtualPetRepository extends CrudRepository<VirtualPet, Long>{
    
}
