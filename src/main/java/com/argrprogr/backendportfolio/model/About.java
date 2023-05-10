/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author franc
 */
@Getter @Setter
@Entity
public class About {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String photourl;
    private String description;
    private String city;
    private String country;
    private String profession;
    private String name;
}
