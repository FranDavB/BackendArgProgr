/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Experience;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IExperienceService {
    public List<Experience> getExperiences();
    
    public void saveExperience(Experience exp);
    
    public void deleteExperience(Long id);
    
    public Experience findExperience(Long id);
}
