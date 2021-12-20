package io.javabrains.springsecurityjpa.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {
    //initial code from Full Stack Development with Spring Boot 2 and React by Juha Hinkula

    static final long EXPIRATIONTIME=864_000_00;
    //1 day

    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    //Add token to Auth header
    static public void addToken(HttpServletResponse res, String username) {
        System.out.println("In the addTOken method!");
        String jwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + jwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
        //javascript won't have access unless we expose headers!
    }

    //Get token from Auth header
    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null){
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            }

        }
        return null;

    } //end getAuthentication()
}
