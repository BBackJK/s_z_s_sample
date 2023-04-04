package com.example.szs.infrastructure.jwt;

import com.example.szs.core.user.domain.User;
import com.example.szs.infrastructure.annotations.Provider;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Base64;
import java.util.Date;

@Provider
@Slf4j
public class JwtProvider {

    private final String secretKey;
    private final long expiredTime;

    public JwtProvider(
            @Value("${jwt.secret-key}") String secretKey
            , @Value("${jwt.expired-minutes}") int expiredMinutes
    ) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.expiredTime = expiredMinutes * 60 * 1000L;
    }

    public String createToken(User user) {

        Claims claims = Jwts.claims().setSubject(user.getUserId());
        claims.put("name", user.getName());

        final Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + this.expiredTime))
                .signWith(SignatureAlgorithm.HS256, this.secretKey)
                .compact();
    }

    public String parseUserIdByToken(String token) {
        Jws<Claims> claims = this.parseClaimsByToken(token);
        return claims == null ? "" : claims.getBody().getSubject();
    }

    public boolean isValidateExpiration(String token) {
        Jws<Claims> claims = this.parseClaimsByToken(token);
        return claims != null && !claims.getBody().getExpiration().before(new Date());
    }

    private Jws<Claims> parseClaimsByToken(String token) {
        Jws<Claims> result = null;
        try {
            result = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token);
        } catch (UnsupportedJwtException ex) {  // if the claimsJws argument does not represent an Claims JWS
            // jwt 가 예상하는 형식과 다른 형식이거나 다른 구성
            log.info(ex.getMessage());
        } catch (MalformedJwtException ex) {    // if the claimsJws string is not a valid JWS
            // 잘못된 jwt 구조
            log.info(ex.getMessage());
        } catch (SignatureException ex) {       // if the claimsJws JWS signature validation fails
            // jwt 서명실패 (변조)
            log.info(ex.getMessage());
        } catch (ExpiredJwtException ex) {      // if the specified JWT is a Claims JWT and the Claims has an expiration time before the time this method is invoked.
            // jwt 유효시간 초과
            log.info(ex.getMessage());
        } catch (IllegalArgumentException ex) { // if the claimsJws string is null or empty or only whitespace
            // 잘못된 인자 즉 토큰 자체가 null이거나 다른 경우
            log.info(ex.getMessage());
        }

        return result;
    }
}
