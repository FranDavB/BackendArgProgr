/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Formation;
import com.argrprogr.backendportfolio.repositories.FormationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class FormationService implements IFormationService{

    @Autowired
    private FormationRepository formRepo;
    @Override
    public List<Formation> getFormations() {
        List<Formation> listaFormaciones = formRepo.findAll();
        return listaFormaciones;
    }

    @Override
    public void saveFormation(Formation formation) {
        formRepo.save(formation);
    }

    @Override
    public void deleteFormation(Long id) {
        formRepo.deleteById(id);
    }

    @Override
    public Formation findFormation(Long id) {
        Formation form = formRepo.findById(id).orElse(null);
        return form;
    }
    
}
