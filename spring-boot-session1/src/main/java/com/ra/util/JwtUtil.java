package com.ra.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private long EXPIRED = (1000 * 60 * 2);
    private String JWT_SECRET_KEY = "ra_secret_key";

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expired = new Date(now.getTime() + EXPIRED);
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
        return token;
    }
    public String getUsernameFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return username;
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
