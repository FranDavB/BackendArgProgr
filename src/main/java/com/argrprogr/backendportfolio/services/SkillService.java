/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Skill;
import com.argrprogr.backendportfolio.repositories.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class SkillService implements ISkillService {
    
    @Autowired
    private SkillRepository skillRepo;

    @Override
    public List<Skill> getSkills() {
        List<Skill> listaHabilidades = skillRepo.findAll();
        return listaHabilidades;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = skillRepo.findById(id).orElse(null);
        return skill;
    }
    
}
