/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argrprogr.backendportfolio.repositories;

import com.argrprogr.backendportfolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author franc
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
}
