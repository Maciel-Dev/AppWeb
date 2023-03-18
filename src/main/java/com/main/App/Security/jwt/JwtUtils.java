package com.main.App.Security.jwt;

import com.main.App.Security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("$(WebApp.app.jwtSecret)")
    private String jwtSecret;

//    @Value("$(WebApp.app.jwtExpirationMs)")
//    private int jwtExpirationMs;

    @Value("$(WebApp.app.jwtCookieName)")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request)
    {
        Cookie cookie = WebUtils.getCookie(request, String.valueOf("token"));
        if(cookie != null)
        {
            return cookie.getValue();
        }
        else
        {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal)
    {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        return ResponseCookie.from("token" ,jwt).path("/api").maxAge(24*60*60).httpOnly(true).build();
    }

    public ResponseCookie getCleanJwtCookie()
    {
        return ResponseCookie.from("token", null).path("/api").build();
    }

    public String getUserNameFromJwtToken(String token)
    {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken)
    {
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException e)
        {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        }
        catch (MalformedJwtException e)
        {
            logger.error("Invalid JWT token: {}", e.getMessage());
        }
        catch (UnsupportedJwtException e)
        {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        }

        return false;
    }

    public String generateTokenFromUsername(String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 8000000))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
}
