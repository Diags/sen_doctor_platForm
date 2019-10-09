package sen_doctor.service;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sen_doctor.errorHandle.InvalidTokenRequestException;
import sen_doctor.model.Professionnal;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    @Value("${auth.token.validity.duration:180}")
    private int tokenValidityDuration;
    @Value("${auth.token.SECRET:xreflite_ABB@abb.com}")
    private String SECRET;

    public String generateToken(Professionnal professionnal) {

        logger.info("{generateToken} user  " + professionnal);
        String jwtToken = Jwts.builder()
                .setSubject(null)
                .setExpiration(null)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .claim("roles", null)
                .compact();
        logger.info("Token user  " + jwtToken);
        return jwtToken;
    }

    public Date getJwtExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public Claims getJwtClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
            throw new InvalidTokenRequestException("InvalidSignatureJWT", authToken, "Invalid JWT signature");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
            throw new InvalidTokenRequestException("ExpiredJWT", authToken, "Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
            throw new InvalidTokenRequestException("InvalidJWT", authToken, "Invalid JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
            throw new InvalidTokenRequestException("UnsupportedJWT", authToken, "Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
            throw new InvalidTokenRequestException("claimsJWT", authToken, "JWT claims string is empty.");
        }
    }
}
