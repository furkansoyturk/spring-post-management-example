package com.youngadessi.demo.filter;

import com.youngadessi.demo.api.auth.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

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
                List<String> authorization = exchange.getRequest().getHeaders().getOrEmpty("Authorization");
                boolean isHeaderEmpty = authorization.isEmpty();

                if(isHeaderEmpty){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                }else{

                    String jwtToken = authorization.get(0);
                    if (validationService.validate(jwtToken) == 200 ){
                        exchange.getResponse().setStatusCode(HttpStatus.ACCEPTED);
                        return chain.filter(exchange);
                    }
                    if (validationService.validate(jwtToken) ==401){
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    }
                    if(validationService.validate(jwtToken) == 500){
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    }
                }



            } catch (IOException e) {
                throw new RuntimeException();
            }
            return exchange.getResponse().setComplete();
        };
    }

    public static class Config {
        // Put the configuration properties
    }
}