package com.inmobicasaventas.gestinmo.api.authentication.application.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.inmobicasaventas.gestinmo.api.advisors.domain.models.Advisor;

@Service
public class TokenService {
    @Value("${api.jwt.secret}")
    private String jwtSecret;

    public String generateJWT(Advisor advisor) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return JWT.create()
                    .withIssuer("Gestinmo")
                    .withSubject(advisor.getLogin())
                    .withClaim("id", advisor.getId())
                    .withClaim("name", advisor.getName())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret); 
            verifier = JWT.require(algorithm)
                    .withIssuer("Gestinmo")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verifier invalido");
        }
        return verifier.getSubject();
    }
}
