/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Formation;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IFormationService {
    public List<Formation> getFormations();
    
    public void saveFormation(Formation formation);
    
    public void deleteFormation(Long id);
    
    public Formation findFormation(Long id);
    
}
