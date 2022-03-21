package com.youngadessi.demo.user.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, max = 32, message = "username length should be between 8 and 32 characters")
    //@Column(name = "username", nullable = false, unique = true)
    private String username;

    @Size(min = 8, max = 32, message = "password length should be between 8 and 32 characters")
    //@Column(name = "password", nullable = false)
    private String password;

    @Version
    //@Column(name = "version")
    private  Integer version;

}
