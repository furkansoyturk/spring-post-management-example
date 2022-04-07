package com.youngadessi.demo.security.model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JWTRequestDTO implements Serializable {

    private String username;

    private String password;

}
