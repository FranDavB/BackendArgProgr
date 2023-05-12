/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.controller;

import com.argrprogr.backendportfolio.model.About;
import com.argrprogr.backendportfolio.model.Experience;
import com.argrprogr.backendportfolio.model.Formation;
import com.argrprogr.backendportfolio.model.Project;
import com.argrprogr.backendportfolio.model.Skill;
import com.argrprogr.backendportfolio.services.AboutService;
import com.argrprogr.backendportfolio.services.ExperienceService;
import com.argrprogr.backendportfolio.services.FormationService;
import com.argrprogr.backendportfolio.services.IStorageService;
import com.argrprogr.backendportfolio.services.ProjectService;
import com.argrprogr.backendportfolio.services.SkillService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author franc
 */
@RestController
@AllArgsConstructor

public class BackendController {
    @Autowired
    private final ExperienceService expServ;
   
    
    @GetMapping("/api/traer/experiencia")
    public List<Experience> getExperiences(){
        return expServ.getExperiences();
    }
    
    @PostMapping("/api/agregar/experiencia")
    public Experience postPersona(@RequestBody Experience exp){
          expServ.saveExperience(exp);
        return exp;
    }
    
    @DeleteMapping("/api/borrar/experiencia/{id}")
    public void deletePersona(@PathVariable Long id){
        expServ.deleteExperience(id);
    }

    @PutMapping("/api/editar/experiencia/{id}")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestBody Experience exp){
        
        Experience editExp = expServ.findExperience(id);
        
        //crear metodo en IPersonaService y Override en PersonaService que "updatee" los datos
        
        editExp.setName(exp.getName());
        editExp.setLogourl(exp.getLogourl());
        editExp.setDescription(exp.getDescription());
        editExp.setStartDate(exp.getStartDate());
        editExp.setEndDate(exp.getEndDate());
        
        //Hasta aca solo se genero una variable del tipo Persona y se le definieron los atributos, pero no esta guardado
        // Entonces se tiene que ejecutar el cmd de abajo para que actualice en la db
        
        expServ.saveExperience(editExp);
        
        return editExp;
    }    
    
    // About
    
    @Autowired
    private final AboutService abService;
    
    
    @GetMapping("/api/traer/acerca-de")
    public List<About> getAbout(){
        return abService.getAbout();
    }
    
    @PutMapping("/api/editar/acerca-de/{id}")
    public About editAbout(@PathVariable Long id,
                                @RequestBody About about){
        
        About editAbout = abService.findAbout(id);
        
        //crear metodo en IPersonaService y Override en PersonaService que "updatee" los datos
        
        editAbout.setName(about.getName());
        editAbout.setPhotourl(about.getPhotourl());
        editAbout.setDescription(about.getDescription());
        editAbout.setProfession(about.getProfession());
        editAbout.setCity(about.getCity());
        editAbout.setCountry(about.getCountry());


        
        //Hasta aca solo se genero una variable del tipo Persona y se le definieron los atributos, pero no esta guardado
        // Entonces se tiene que ejecutar el cmd de abajo para que actualice en la db
        
        abService.saveAbout(editAbout);
        
        return editAbout;
    }  
    
    //Formation
    
    @Autowired
    private final FormationService formationService;
   
    
    @GetMapping("/api/traer/formacion")
    public List<Formation> getFormations(){
        return formationService.getFormations();
    }
    
    @PostMapping("/api/agregar/formacion")
    public Formation postFormation(@RequestBody Formation formation){
          formationService.saveFormation(formation);
        return formation;
    }
    
    @DeleteMapping("/api/borrar/formacion/{id}")
    public void deleteFormation(@PathVariable Long id){
        formationService.deleteFormation(id);
    }

    @PutMapping("/api/editar/formacion/{id}")
    public Formation editFormation(@PathVariable Long id,
                                     @RequestBody Formation formation){
        
        Formation editFormation = formationService.findFormation(id);
        
        //crear metodo en IPersonaService y Override en PersonaService que "updatee" los datos
        
        editFormation.setTitle(formation.getTitle());
        editFormation.setLogoAcademy(formation.getLogoAcademy());
        editFormation.setDescription(formation.getDescription());
        editFormation.setStartDate(formation.getStartDate());
        editFormation.setEndDate(formation.getEndDate());
        
        //Hasta aca solo se genero una variable del tipo Persona y se le definieron los atributos, pero no esta guardado
        // Entonces se tiene que ejecutar el cmd de abajo para que actualice en la db
        
        formationService.saveFormation(editFormation);
        
        return editFormation;
    }

    @Autowired
    private final ProjectService projServ;
   
    
    @GetMapping("/api/traer/proyecto")
    public List<Project> getProjects(){
        return projServ.getProjects();
    }
    
    @PostMapping("/api/agregar/proyecto")
    public Project postProject(@RequestBody Project proj){
          projServ.saveProject(proj);
        return proj;
    }
    
    @DeleteMapping("/api/borrar/proyecto/{id}")
    public void deleteProject(@PathVariable Long id){
        projServ.deleteProject(id);
    }

    @PutMapping("/api/editar/proyecto/{id}")
    public Project editProject(@PathVariable Long id,
                                     @RequestBody Project proj){
        
        Project editProj = projServ.findProject(id);
        
        //crear metodo en IPersonaService y Override en PersonaService que "updatee" los datos
        
        editProj.setTitle(proj.getTitle());
        editProj.setImageProject(proj.getImageProject());
        editProj.setDescription(proj.getDescription());
        editProj.setUrl(proj.getUrl());
        
        //Hasta aca solo se genero una variable del tipo Persona y se le definieron los atributos, pero no esta guardado
        // Entonces se tiene que ejecutar el cmd de abajo para que actualice en la db
        
        projServ.saveProject(editProj);
        
        return editProj;
    } 
    
    //Skill
    
    @Autowired
    private final SkillService skillServ;
   
    
    @GetMapping("/api/traer/habilidad")
    public List<Skill> getSkills(){
        return skillServ.getSkills();
    }
    
    @PostMapping("/api/agregar/habilidad")
    public Skill postSkill(@RequestBody Skill skill){
          skillServ.saveSkill(skill);
        return skill;
    }
    
    @DeleteMapping("/api/borrar/habilidad/{id}")
    public void deleteSkill(@PathVariable Long id){
        skillServ.deleteSkill(id);
    }

    @PutMapping("/api/editar/habilidad/{id}")
    public Skill editSkill(@PathVariable Long id,
                                     @RequestBody Skill skill){
        
        Skill editSkill = skillServ.findSkill(id);
        
        //crear metodo en IPersonaService y Override en PersonaService que "updatee" los datos
        
        editSkill.setTitle(skill.getTitle());
        editSkill.setPercentage(skill.getPercentage());

        //Hasta aca solo se genero una variable del tipo Persona y se le definieron los atributos, pero no esta guardado
        // Entonces se tiene que ejecutar el cmd de abajo para que actualice en la db
        
        skillServ.saveSkill(editSkill);
        
        return editSkill;
    }    
    
    private final IStorageService storageService;  
    private final HttpServletRequest request;
    
    
    @PostMapping ("/subir/archivo")
    public Map<String, String> uploadFile (@RequestParam("file") MultipartFile multipartFile) {
        String path = storageService.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/obtener/archivo/")
                .path(path)
                .toUriString();
        return Map.of("url",url);
    }
    
    @GetMapping ("obtener/archivo/{nombreArchivo}")
    public ResponseEntity <Resource> getFile(@PathVariable String nombreArchivo) throws IOException {
        Resource file = storageService.loadAsResource(nombreArchivo);
        String contentType = Files.probeContentType(file.getFile().toPath());
        
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }

}
    

