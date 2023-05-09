/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.controller;

import com.argrprogr.backendportfolio.model.About;
import com.argrprogr.backendportfolio.model.Experience;
import com.argrprogr.backendportfolio.services.AboutService;
import com.argrprogr.backendportfolio.services.ExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

/**
 *
 * @author franc
 */
@RestController
public class BackendController {
    @Autowired
    private ExperienceService expServ;
   
    
    @GetMapping("/api/experiencias/traer")
    public List<Experience> getExperiences(){
        return expServ.getExperiences();
    }
    
    @PostMapping("/api/experiencias/agregar")
    public Experience postPersona(@RequestBody Experience exp){
          expServ.saveExperience(exp);
        return exp;
    }
    
    @DeleteMapping("/api/experiencias/borrar/{id}")
    public void deletePersona(@PathVariable Long id){
        expServ.deleteExperience(id);
    }

    @PutMapping("/api/experiencias/editar/{id}")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestBody Experience exp){
        
        Experience editExp = expServ.findExperience(id);
        
        //crear metodo en IPersonaService y Override en PersonaService que "updatee" los datos
        
        editExp.setName(exp.getName());
        editExp.setLogourl(exp.getLogourl());
        editExp.setDescription(exp.getDescription());
        editExp.setDate(exp.getDate());
        
        //Hasta aca solo se genero una variable del tipo Persona y se le definieron los atributos, pero no esta guardado
        // Entonces se tiene que ejecutar el cmd de abajo para que actualice en la db
        
        expServ.saveExperience(editExp);
        
        return editExp;
    }    
    
    // About
    
    @Autowired
    private AboutService abService;
    
    
    @GetMapping("/api/acerca-de")
    public List<About> getAbout(){
        return abService.getAbout();
    }
    
    @PostMapping("/api/acerca-de/editar")
    public String saveAbout(@RequestBody About about){
        abService.saveAbout(about);
        return "Sección acerca de editada correctamente";
    }
    
    
}
