/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.springmvcapp.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Adam
 */
@Entity
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ownerFirstName;

    private String ownerLastName;

    private String ownerAdress;

    private String ownerCity;
    
    private Integer ownerTelephone;
    
    public Owner() {
    }
    
    public Owner(String ownerFirstName, String ownerLastName, String ownerAdress, String ownerCity, Integer ownerTelephone) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerAdress = ownerAdress;
        this.ownerCity = ownerCity;
        this.ownerTelephone = ownerTelephone;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }
    
    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }
    
    public String getOwnerAdress() {
        return ownerAdress;
    }

    public void setOwnerAdress(String ownerAdress) {
        this.ownerAdress = ownerAdress;
    }
    
    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }
    
    public Integer getOwnerTelephone() {
        return ownerTelephone;
    }

    public void setOwnerTelephone(Integer ownerTelephone) {
        this.ownerTelephone = ownerTelephone;
    }

}
