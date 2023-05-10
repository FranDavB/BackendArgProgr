/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import com.argrprogr.backendportfolio.model.Project;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IProjectService {
    
    public List<Project> getProjects();
    
    public void saveProject(Project proj);
    
    public void deleteProject(Long id);
    
    public Project findProject(Long id);
}
