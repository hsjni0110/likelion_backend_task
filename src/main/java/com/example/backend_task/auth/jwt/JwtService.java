package com.example.backend_task.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final long accessTokenExpirationDayToMills;
    private final Algorithm algorithm;

    public JwtService(JwtProperty jwtProperty) {
        this.accessTokenExpirationDayToMills = jwtProperty.accessTokenExpirationDay() * 24 * 60 * 60 * 1000;
        this.algorithm = Algorithm.HMAC512(jwtProperty.secretKey());
    }

    public String createToken(Long memberId) {
        return JWT.create()
                .withExpiresAt(new Date(
                        accessTokenExpirationDayToMills + System.currentTimeMillis()
                ))
                .withIssuedAt(new Date())
                .withClaim("memberId", memberId)
                .sign(algorithm);
    }
}
