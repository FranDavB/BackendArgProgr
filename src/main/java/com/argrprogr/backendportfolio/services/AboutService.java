/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.About;
import com.argrprogr.backendportfolio.repositories.AboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class AboutService implements IAboutService {
    @Autowired
    private AboutRepository abRepo;

    @Override
    public List<About> getAbout() {
        List<About> listaAbout = abRepo.findAll();
        return listaAbout;
    }

    @Override
    public void saveAbout(About about) {
        abRepo.save(about);
    }
}
