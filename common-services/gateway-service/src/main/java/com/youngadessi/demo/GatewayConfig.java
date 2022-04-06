//package com.youngadessi.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Configuration
//public class GatewayConfig {
//
//    @Autowired
//    private JwtAuthenticationFilter filter;
//
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes().route("auth-service", r -> r.path("/auth-service/**").filters(f -> f.filter(filter)).uri("lb://auth-service"))
//                .route("alert", r -> r.path("/alert/**").filters(f -> f.filter(filter)).uri("lb://alert")).build();
//    }
//
//}