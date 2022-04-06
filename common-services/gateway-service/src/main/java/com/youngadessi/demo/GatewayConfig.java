package com.youngadessi.demo;

import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {



//    @Override
//    protected void configure(HttpSecurity security) throws Exception
//    {
//        security.csrf().disable().authorizeRequests().anyRequest().permitAll(); // Works for GET, POST, PUT, DELETE
//    }


//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//
//        return builder.routes()
//                .route("post", r -> r.path("/post-service/**")
////                        .filters(f -> f.filter(filter))
//                        .uri("http://localhost:8086/"))
//                .route("auth-service", r -> r.path("/auth-service/**")
////                        .filters(f -> f.filter(filter))
//                        .uri("http://localhost:8085/"))
//                .build();
//    }

}