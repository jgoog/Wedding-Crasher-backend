package com.example.weddingcrasher.weddingcrasherback.service;

import com.example.weddingcrasher.weddingcrasherback.security.JWTRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // only allowed urls with out JWT
        http.authorizeRequests().antMatchers(
                        "/auth/users/", "/auth/users/login/", "/auth/users/register/", "/api/hello-world/").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // for token
    }



}
