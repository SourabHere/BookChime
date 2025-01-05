package com.bookExchange.UserService.Config;

import com.bookExchange.UserService.Security.JwtAuthenticationEntryPoint;
import com.bookExchange.UserService.Security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class Securityconfig {
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/api/v1/users/**").authenticated().requestMatchers("/test").authenticated().
                        requestMatchers("/api/v1/auth/login").permitAll().
                        anyRequest().authenticated())

                .exceptionHandling(ex->ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }



}
