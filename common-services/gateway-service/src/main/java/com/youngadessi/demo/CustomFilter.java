package com.youngadessi.demo;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    @Autowired
    JwtValidate jwtValidate;

    public CustomFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            try {
                ServerHttpRequest serverHttpRequest = exchange.getRequest();
                String jwtToken = serverHttpRequest.getHeaders().getFirst("Authorization");

                if (jwtValidate.validate(jwtToken) == 200 ){
                    exchange.getResponse().setStatusCode(HttpStatus.OK);
                }
                if (jwtValidate.validate(jwtToken) ==401){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                }
                if(jwtValidate.validate(jwtToken) == 500){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                }

            } catch (IOException e) {
                throw new RuntimeException();
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Put the configuration properties
    }
}