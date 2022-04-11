package com.youngadessi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GatewayServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }


//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/auth-service/login")
//                        .uri("http://localhost:8085/")
//
//                )
//                .route(r -> r
//                            .path("/post-service/**")
////                            .filters(f -> f.tokenRelay())
////                            .filters(f -> f.)
////                          .filters(f -> f.addRequestHeader("Hello", "World"))
//                            .uri("http://localhost:8088/"))
//                .build();
//    }
//

}
