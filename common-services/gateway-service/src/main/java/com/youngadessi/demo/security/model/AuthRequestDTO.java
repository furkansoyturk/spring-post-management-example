package com.youngadessi.demo.security.model;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDTO {

    private String username;

    private String password;

}
