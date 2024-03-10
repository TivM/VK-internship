package com.example.demo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.demo.user.Permission.*;
import static com.example.demo.user.Role.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/api/auth/**")
                                .permitAll()
                                .requestMatchers("/api/posts/**").hasAnyRole(ADMIN.name(), POSTS.name())
                                .requestMatchers(GET, "/api/posts/**").hasAnyAuthority(ADMIN_READ.name(), POSTS_READ.name())
                                .requestMatchers(POST, "/api/posts/**").hasAnyAuthority(ADMIN_CREATE.name(), POSTS_CREATE.name())
                                .requestMatchers(PUT, "/api/posts/**").hasAnyAuthority(ADMIN_UPDATE.name(), POSTS_UPDATE.name())
                                .requestMatchers(DELETE, "/api/posts/**").hasAnyAuthority(ADMIN_DELETE.name(), POSTS_DELETE.name())

                                .requestMatchers("/api/users/**").hasAnyRole(ADMIN.name(), USERS.name())
                                .requestMatchers(GET, "/api/users/**").hasAnyAuthority(ADMIN_READ.name(), USERS_READ.name())
                                .requestMatchers(POST, "/api/users/**").hasAnyAuthority(ADMIN_CREATE.name(), USERS_CREATE.name())
                                .requestMatchers(PUT, "/api/users/**").hasAnyAuthority(ADMIN_UPDATE.name(), USERS_UPDATE.name())
                                .requestMatchers(DELETE, "/api/users/**").hasAnyAuthority(ADMIN_DELETE.name(), USERS_DELETE.name())

                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
