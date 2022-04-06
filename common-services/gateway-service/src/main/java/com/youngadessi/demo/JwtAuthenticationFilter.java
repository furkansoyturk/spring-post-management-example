//package com.youngadessi.demo;
//
//import com.youngadessi.demo.auth.jwt.api.JWTFilter;
//import java.util.List;
//import java.util.function.Predicate;
//
//import com.youngadessi.demo.auth.jwt.api.JWTManager;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Component
//public class JwtAuthenticationFilter implements GatewayFilter {
//
//    @Autowired
//    JWTFilter jwtFilter;
//
//    @Autowired
//    JWTManager jwtManager;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//
//        final List<String> apiEndpoints = List.of("/register", "/login");
//
//        Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
//                .noneMatch(uri -> r.getURI().getPath().contains(uri));
//
//        if (isApiSecured.test(request)) {
//            if (!request.getHeaders().containsKey("Authorization")) {
//                ServerHttpResponse response = exchange.getResponse();
//                response.setStatusCode(HttpStatus.UNAUTHORIZED);
//
//                return response.setComplete();
//            }
//
//            final String token = request.getHeaders().getOrEmpty("Authorization").get(0);
//
//
//
//                ServerHttpResponse response = exchange.getResponse();
//                response.setStatusCode(HttpStatus.BAD_REQUEST);
//
//                return response.setComplete();
//
//            Claims managerClaims = jwtManager.getClaims(token);
//            exchange.getRequest().mutate().header("id", String.valueOf(jwtManager.getClaims(token).get("id"))).build();
//        }
//
//        return chain.filter(exchange);
//    }
//
//}