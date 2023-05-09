/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.security;

import com.argrprogr.backendportfolio.model.Usuario;
import com.argrprogr.backendportfolio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = userRep
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email " + email + " no existe"));
        
        return new UserDetailsImpl(usuario);
    }
    
}
