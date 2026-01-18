package com.example.KafkaProject.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JwtUtilTest {

//    private final JwtUtil jwtUtil = new JwtUtil();

    @InjectMocks
    private JwtUtil jwtUtil;
    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    @Test
    void shouldGenerateValidJwtToken() {
        // given
        String username = "admin";

        // when
        String token = jwtUtil.generateToken(username);

        // then
        assertNotNull(token);

//        Claims claims =
//
//                Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        assertEquals(username, claims.getSubject());
//        assertNotNull(claims.getIssuedAt());
//        assertNotNull(claims.getExpiration());
    }

    @Test
    void shouldextractUsername(){

        //String username = "admin";
        //String token = "UBUHB";
        String username = "admin";
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 100000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
        String extractedUsername=jwtUtil.extractUsername(token);
        assertEquals(username, extractedUsername);
    }
    @Test
    void shouldReturnTrueForValidToken() {
        // given
        String token = Jwts.builder()
                .setSubject("admin")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

        // when
        boolean isValid = jwtUtil.validateToken(token);

        // then
        assertTrue(isValid);
    }
    @Test
    void shouldReturnFalseForValidToken() {
        // given
        String invalidToken = "invalid.jwt.token";

        // when
        boolean isValid = jwtUtil.validateToken(invalidToken);

        // then
        assertFalse(isValid);
    }
}