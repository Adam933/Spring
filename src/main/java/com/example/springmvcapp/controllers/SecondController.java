/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springmvcapp.controllers;

import com.example.springmvcapp.models.Owner;
import com.example.springmvcapp.models.Pet;
import com.example.springmvcapp.repositories.PetRepository;
import com.example.springmvcapp.repositories.OwnerRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Adam
 */
@Controller
public class SecondController {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    PetRepository petRepository;
    
    // WYœwietlanie listy ownerów
    @RequestMapping("/owner")
    public String owner(Model model) {
        model.addAttribute("owners", ownerRepository.findAll());
        return "owner";
    }
    /*
    @RequestMapping("/owners")
    public String owners(Model model) {
        //return "redirect:/ownerInformation/" + owner.getId(); // Przechodzi do widoku zapisanego produktu
        return "redirect:/owner";
    }*/
    
    // Reakcja na klikniecie FIND OWNER
    @RequestMapping("/owners")
    public String owners(@RequestParam String ownerLastName, Model model) {
        if(ownerLastName == "") return "redirect:/owner";
        Integer row = ownerRepository.countByOwnerLastName(ownerLastName);
        if(row > 1){
            model.addAttribute("owners", ownerRepository.findByOwnerLastName(ownerLastName));
            return "owner";
        }
        if(row == 1){
            List<Owner> owners; 
            Owner owner;
            owners = ownerRepository.findByOwnerLastName(ownerLastName);
            owner = owners.get(0);
            return "redirect:/ownerInformation/" + owner.getId(); // Przechodzi do widoku zapisanego produktu
        }
        return "owner";
    }
    
    @RequestMapping("/saveOwner")
    public String saveOwner(@RequestParam String ownerFirstName, @RequestParam String ownerLastName, @RequestParam String ownerAdress, @RequestParam String ownerCity, @RequestParam Integer ownerTelephone) {
        Owner owner = new Owner();
        owner.setOwnerFirstName(ownerFirstName);
        owner.setOwnerLastName(ownerLastName);
        owner.setOwnerAdress(ownerAdress);
        owner.setOwnerCity(ownerCity);
        owner.setOwnerTelephone(ownerTelephone);
        ownerRepository.save(owner);

        //return "redirect:/owner";
        return "redirect:/ownerInformation/" + owner.getId(); // Przechodzi do widoku zapisanego produktu
    }
    
    @RequestMapping("/ownerInformation/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("owner", ownerRepository.findById(id).orElse(null));
        //String name = "Leo";
        //Integer row = petRepository.countByName(name);
        model.addAttribute("pets", petRepository.findByOwnerID(id));
        return "ownerInformation";
    }
    
    @RequestMapping("/addOwner")
    public String addOwner(Model model) {
        return "addOwner";
    }
    
    @RequestMapping("/findOwner")
    public String findOwner(Model model) {
        return "findOwner";
    }
    
    @RequestMapping("/editOwner/{id}")
    public String editOwner(@PathVariable Long id, Model model) {
        model.addAttribute("owner", ownerRepository.findById(id).orElse(null));
        return "editOwner";
    }
    
    @RequestMapping("/deleteOwner")
    public String delete(@RequestParam Long id) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        ownerRepository.delete(owner);

        return "redirect:/owner";
    }

    @RequestMapping("/updateOwner")
    public String updateOwner(@RequestParam Long id, @RequestParam String ownerFirstName, @RequestParam String ownerLastName, @RequestParam String ownerAdress, @RequestParam String ownerCity, @RequestParam Integer ownerTelephone) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        owner.setOwnerFirstName(ownerFirstName);
        owner.setOwnerLastName(ownerLastName);
        owner.setOwnerAdress(ownerAdress);
        owner.setOwnerCity(ownerCity);
        owner.setOwnerTelephone(ownerTelephone);
        ownerRepository.save(owner);

        return "redirect:/ownerInformation/" + owner.getId();
    }
    
    @RequestMapping("/addPet/{id}")
    public String addPet(@PathVariable Long id, Model model) {
        model.addAttribute("owner", ownerRepository.findById(id).orElse(null));
        return "addPet";
    }
    
    @RequestMapping("/savePet")
    public String savePet(@RequestParam String ownerFirstName, @RequestParam String name, @RequestParam String birthDate, @RequestParam String type) throws ParseException {
        //SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");  
        //Date date=form.parse(birthDate);  
        
        Owner owner = ownerRepository.findByOwnerFirstName(ownerFirstName);
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBirthDate(birthDate);
        pet.setType(type);
        pet.setOwnerID(owner.getId());
        petRepository.save(pet);

        //return "redirect:/owner";
        return "redirect:/ownerInformation/" + owner.getId(); // Przechodzi do widoku zapisanego produktu
    }
    
}

