/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Project;
import com.argrprogr.backendportfolio.repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class ProjectService implements IProjectService{

    @Autowired
    private ProjectRepository projRepo;
    
    @Override
    public List<Project> getProjects() {
        List<Project> listaProyectos = projRepo.findAll();
        return listaProyectos;
    }

    @Override
    public void saveProject(Project proj) {
        projRepo.save(proj);
    }

    @Override
    public void deleteProject(Long id) {
        projRepo.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project proj = projRepo.findById(id).orElse(null);
        return proj;
    }
    
}
