package com.tts1;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //Security Config class configure()
    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                //Filter for api/login reqs
                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                //Filter for other requests to check JWT in header
                .addFilterBefore(new AuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.SetAllowedOrigins(Arrays.asList("*"));
        config.SetAllowedMethods(Arrays.asList("*"));
        config.SetAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();
        source.registerCorsConfiguration("/**"), config);
        return source;

    }
}


// From https://www.codejava.net/frameworks/spring-boot/form-authentication-with-jdbc-and-mysql
// We have a custom sql connection

// import javax.sql.DataSource;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.*;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//     @Autowired
//     private DataSource dataSource;
//
//     @Autowired
//     public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//         auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                 .dataSource(dataSource)
//                 .usersByUsernameQuery("select username, password, enabled from users where username=?")
//                 .authoritiesByUsernameQuery("select username, role from users where username=?")
//         ;
//     }
//
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//                 .anyRequest().authenticated()
//                 .and()
//                 .formLogin().permitAll()
//                 .and()
//                 .logout().permitAll();
//     }
// }

