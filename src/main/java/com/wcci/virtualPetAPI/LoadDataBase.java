package com.wcci.virtualPetAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wcci.virtualPetAPI.model.VirtualPet;
import com.wcci.virtualPetAPI.repository.VirtualPetRepository;


@SpringBootApplication
public class LoadDataBase {

@Autowired
VirtualPetRepository virtualPetRepository;

    public static void main(String[] args) {
        SpringApplication.run(LoadDataBase.class, args);
    }

    @Bean
    public String running(){
    
        virtualPetRepository.save(new VirtualPet("Dog", "Cooper", "Small pup riddled with anxiety", "50", "30", "100"));
        virtualPetRepository.save(new VirtualPet("Dog", "Zelda", "Big dog, big dumb except when it comes to getting food", "100", "30", "70"));
        virtualPetRepository.save(new VirtualPet("Cat", "Kitty", "Fattest cat ive ever seen", "100", "100", "0"));
        virtualPetRepository.save(new VirtualPet("Bird", "Quincy", "Will mimic all sounds", "20", "50", "80"));
        virtualPetRepository.save(new VirtualPet("Fish", "Fin", "Loves going in circles", "30", "0", "100"));
        
        System.out.println(virtualPetRepository.findAll());

        System.out.println(virtualPetRepository.findById(2L));


        return "running";
    }
}

