package com.youngadessi.demo;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints= List.of(
            "/auth/register",
            "/auth-service/login"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}

// http.csrf().disable()
//         .authorizeRequests().antMatchers("/login").permitAll()
//         .anyRequest().authenticated()
//         .and()
//         .exceptionHandling().authenticationEntryPoint(JWTauthenticationEntryPoint)
//         .and()
//         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//         http.addFilterBefore(JWTFilter, UsernamePasswordAuthenticationFilter.class);