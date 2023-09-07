package com.wcci.virtualPetAPI.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wcci.virtualPetAPI.model.VirtualPet;
import com.wcci.virtualPetAPI.repository.VirtualPetRepository;

@Controller
public class VirtualPetController {

    @Autowired
    VirtualPetRepository virtualPetRepository;

    @GetMapping("/getVirtualPet/{id}")
    public String getVirtualPet(@PathVariable long id, Model model) {
        Optional<VirtualPet> optionalPet = virtualPetRepository.findById(id);
        if (optionalPet.isPresent()) {
            VirtualPet pet = optionalPet.get();
            List<VirtualPet> pets = Arrays.asList(pet);
            model.addAttribute("virtualPets", pet);
            
            return "VirtualPetTemplate";
        } else {
            model.addAttribute("errorMessage", "You cannot receive that pet, it does not exist!");
            return "ErrorMessage";
        }
    }

    // @GetMapping("/getPetsByType/{petType}")
    // public String getPetsByType(@PathVariable String petType, Model model){
        
    // }

    @GetMapping("/getAllVirtualPets")
    public String getAllVirtualPets(Model model) {
        addVirtualPetModel(model);
        return "VirtualPetTemplate";
    }

    @PostMapping("/createAVirtualPet")
    public String createVirtualPet(@RequestBody VirtualPet virtualPet, Model model) {
        virtualPetRepository.save(virtualPet);
        addVirtualPetModel(model);
        return "VirtualPetTemplate";
    }

    @DeleteMapping("/deleteVirtualPet/{id}")
    public String deleteVirtualPet(@PathVariable Long id, Model model) {
        Optional<VirtualPet> optionalPet = virtualPetRepository.findById(id);
        if (optionalPet.isPresent()) {
            virtualPetRepository.deleteById(id);
            addVirtualPetModel(model);
            return "VirtualPetTemplate";
        } else {
            model.addAttribute("errorMessage", "You cannot delete that pet, it does not exist!");

            return "ErrorMessage";
        }
        
    }

    private void addVirtualPetModel(Model model) {
        Iterable<VirtualPet> virtualPets = virtualPetRepository.findAll();
        model.addAttribute("virtualPets", virtualPets);
    }
}
