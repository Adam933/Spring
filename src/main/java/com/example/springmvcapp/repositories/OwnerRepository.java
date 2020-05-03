/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springmvcapp.repositories;

import com.example.springmvcapp.models.Owner;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Adam
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    
    Owner findByOwnerFirstName(final String ownerFirstName);
    
    List<Owner> findByOwnerLastName(String ownerLastName);
    
    Integer countByOwnerLastName(String ownerLastName);
    
}
