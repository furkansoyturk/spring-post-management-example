package com.youngadessi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("post-service", r -> r.path("/post-service/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8081/"))

                .route("auth-service", r -> r.path("/auth-service/**")
//                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083/"))
                .build();
    }

}