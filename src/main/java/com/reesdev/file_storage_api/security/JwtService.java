package com.reesdev.file_storage_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey secretKey =
            Keys.hmacShaKeyFor("ReeskyGantengBangetBangettttttttt".getBytes());
    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 *60 *60)
                )
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
}
