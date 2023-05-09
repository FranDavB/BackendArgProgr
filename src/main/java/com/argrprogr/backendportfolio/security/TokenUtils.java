/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argrprogr.backendportfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author franc
 */
public class TokenUtils {
    
    private final static String ACCES_TOKEN_SECRET = "rn2po4GRgMrF6mqpkAKftWX91fnelpl6RnvmaRuY9Vel5f";
    private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 86_400L;
    
    public static String createToken(String email){
        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
                    Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        
        String email = claims.getSubject();
        
        return new UsernamePasswordAuthenticationToken(email, null, Collections.EMPTY_LIST);
        } catch (JwtException e){
            return null;
        }
    }
}
