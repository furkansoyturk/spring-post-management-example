package com.youngadessi.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//
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
//@EnableGlobalMethodSecurity(jsr250Enabled = true)

//@EnableWebSecurity
//@Order(100)
@Configuration
@EnableWebSecurity
@EnableWebFluxSecurity
public class GatewayConfig  {

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeExchange().pathMatchers("/login").permitAll()
                .anyExchange().authenticated()
                .and()
                .build();
    }


////    @Override
////    protected void configure(HttpSecurity security) throws Exception
////    {
////        security.csrf().disable().authorizeRequests().anyRequest().permitAll(); // Works for GET, POST, PUT, DELETE
////    }
//
//
////    @Bean
////    public RouteLocator routes(RouteLocatorBuilder builder) {
////
////        return builder.routes()
////                .route("post", r -> r.path("/post-service/**")
//////                        .filters(f -> f.filter(filter))
////                        .uri("http://localhost:8086/"))
////                .route("auth-service", r -> r.path("/auth-service/**")
//////                        .filters(f -> f.filter(filter))
////                        .uri("http://localhost:8085/"))
////                .build();
////    }
//
}