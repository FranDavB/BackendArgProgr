/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Experience;
import com.argrprogr.backendportfolio.repositories.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class ExperienceService implements IExperienceService{
    
    @Autowired
    private ExperienceRepository expRepo;

    @Override
    public List<Experience> getExperiences() {
        List<Experience> listaExperiencias = expRepo.findAll();
        return listaExperiencias;
    }

    @Override
    public void saveExperience(Experience exp) {
        expRepo.save(exp);
    }

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience exp = expRepo.findById(id).orElse(null);
        return exp;
    }
    
}
