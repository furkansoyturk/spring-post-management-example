//package com.youngadessi.demo.post.config;
//
//import com.youngadessi.demo.authservice.auth.config.AuthServiceWebSecurityConfig;
//import com.youngadessi.demo.authservice.auth.jwt.JWTAuthenticationEntryPoint;
//import com.youngadessi.demo.authservice.auth.jwt.JWTFilter;
//import com.youngadessi.demo.authservice.auth.jwt.JWTManager;
//import com.youngadessi.demo.authservice.auth.jwt.JWTUserDetailsService;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Component
//public class PostServiceWebSecurityConfig {
//
//    @Bean
//    public AuthServiceWebSecurityConfig authWebSecurityConfig(){
//        return new AuthServiceWebSecurityConfig();
//    }
//
//    @Bean
//    public JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint(){
//        return new JWTAuthenticationEntryPoint();
//    }
//
//    @Bean
//    public JWTUserDetailsService jwtUserDetailsService(){
//        return new JWTUserDetailsService();
//    }
//
//    @Bean
//    public JWTManager jwtManager(){
//        return new JWTManager();
//    }
//
//    @Bean
//    public JWTFilter jwtFilter(){
//        return new JWTFilter();
//    }
//
//}
