package com.esun.social.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


@Component
public class JwtUtil {


    private final String SECRET_KEY =
            "esun-social-media-system-jwt-secret-key-2026";


    private final long EXPIRATION_TIME =
            86400000;



    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );

    }



    public String generateToken(Long userId) {


        return Jwts.builder()

                .setSubject(
                        String.valueOf(userId)
                )

                .setIssuedAt(
                        new Date()
                )

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION_TIME
                        )
                )

                .signWith(
                        getSigningKey(),
                        SignatureAlgorithm.HS256
                )

                .compact();

    }



    public Long extractUserId(String token) {


        String userId =
                Jwts.parserBuilder()

                        .setSigningKey(
                                getSigningKey()
                        )

                        .build()

                        .parseClaimsJws(token)

                        .getBody()

                        .getSubject();



        return Long.valueOf(userId);

    }



    public boolean validateToken(String token) {


        try {


            Jwts.parserBuilder()

                    .setSigningKey(
                            getSigningKey()
                    )

                    .build()

                    .parseClaimsJws(token);


            return true;


        } catch (JwtException e) {


            return false;


        }


    }


}