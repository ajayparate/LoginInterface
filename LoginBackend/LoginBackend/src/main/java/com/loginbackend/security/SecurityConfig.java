package com.loginbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // @Bean
    // public securityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf().disable()
    //         .authorizeRequests()
    //             .antMatchers("/api/auth/**").permitAll() // Allow access to authentication endpoints
    //             .anyRequest().authenticated() // Require authentication for all other requests
    //         .and()
    //         .sessionManagement()
    //             .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Use stateless session management

    //     return http.build();
    // }

    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
