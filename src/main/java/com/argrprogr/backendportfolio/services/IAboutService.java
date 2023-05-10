/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.About;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IAboutService {
    
    public List<About> getAbout();
    
    public About findAbout(Long id);
    
    public void saveAbout (About about);
        
}
