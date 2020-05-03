/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springmvcapp.repositories;

import com.example.springmvcapp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Adam
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    
    Pet findByName(final String name);
    
    Integer countByName(String name);
    
    Pet findByOwnerID(Long ownerID);

    
}
