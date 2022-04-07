package com.youngadessi.demo.authservice.auth.jwt.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class JWTResponseDTO implements Serializable {

    private final String token;


}
