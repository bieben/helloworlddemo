package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/helloworld").authenticated()  // Protect the /api/helloworld route
                        .anyRequest().permitAll()  // Allow all other routes
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Custom login page or default
                        .permitAll()
                )
                .httpBasic(basic -> basic  // Use lambda-based configuration for HTTP Basic authentication
                        .realmName("Spring Security Application")
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Set up an in-memory user store with username 'test' and password '123456'
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("test")
                .password("{noop}123456")  // No password encoding is done here
                .roles("USER")
                .build());
        return manager;
    }
}
