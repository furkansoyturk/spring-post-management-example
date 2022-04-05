package com.youngadessi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;


@Configuration
@Component
public class GatewayConfig {

    @Autowired
    private  JwtAuthenticationFilter filter;

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }


    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth"))
                .route("post-service", r -> r.path("/post-service/**").filters(f -> f.filter(filter)).uri("lb://post-service")).build();
    }

}

