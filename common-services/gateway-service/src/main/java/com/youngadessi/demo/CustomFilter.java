package com.youngadessi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    @Autowired
    ValidationService validationService;

    public CustomFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            try {
                ServerHttpRequest serverHttpRequest = exchange.getRequest();
                String jwtToken = serverHttpRequest.getHeaders().getFirst("Authorization");

                if (validationService.validate(jwtToken) == 200 ){
                    exchange.getResponse().setStatusCode(HttpStatus.OK);
                }
                if (validationService.validate(jwtToken) ==401){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                }
                if(validationService.validate(jwtToken) == 500){
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