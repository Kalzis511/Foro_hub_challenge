package com.exemple.forohub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.exemple.forohub.model.Usuario;
import com.auth0.jwt.JWTVerifier;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(apiSecret);
            return JWT.create()
                    .withIssuer("API ForoHub")
                    .withSubject(usuario.getCorreoElectronico())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al generar token JWT", exception);
        }
    }

    public boolean isValidToken(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("API ForoHub")
                    .build();
            verifier.verify(tokenJWT);
            return true;
        } catch (JWTVerificationException | IllegalArgumentException exception) {
            return false;
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(apiSecret);
            return JWT.require(algorithm)
                    .withIssuer("API ForoHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido");
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.UTC);
    }
}
