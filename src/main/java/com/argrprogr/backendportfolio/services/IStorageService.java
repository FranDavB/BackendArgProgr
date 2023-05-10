/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argrprogr.backendportfolio.services;

import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author franc
 */
public interface IStorageService {
    void init() throws IOException;
    
    String store(MultipartFile file);
    
    Resource loadAsResource(String filename);
}
