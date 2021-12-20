package io.javabrains.springsecurityjpa.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javabrains.springsecurityjpa.models.AccountCredentials;
import io.javabrains.springsecurityjpa.services.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
    //initial code from Full Stack Development with Spring Boot 2 and React by Juha Hinkula

    public LoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
        System.out.println("LOGIN FILTER HAS EEN TRIGGERED!!!!");

        AccountCredentials creds = new ObjectMapper()
                .readValue(req.getInputStream(), AccountCredentials.class);
        System.out.println("MY USER:");
        System.out.println(creds.getUsername());
//          return null;
        Authentication myAuth = getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword(),
                        Collections.emptyList()
                )
        );
        System.out.println(myAuth);
        return myAuth;
    } //end attemptAuthentication()

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth) throws
            IOException, ServletException
    {
        System.out.print("AUTHENTICATION IS SUCCESSFUL, HOPEFULLY");
//        AuthenticationService AuthenticatonService;

        AuthenticationService.addToken(res, auth.getName());
        System.out.println(res.getHeader("Authorization"));

    }
}
