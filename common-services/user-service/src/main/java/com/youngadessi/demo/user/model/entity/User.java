package com.youngadessi.demo.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity(name = "User")
//@Table(name = "tbl_user")
public class User extends BaseEntity {

    //@Size(min = 8, max = 32, message = "username length should be between 8 and 32 characters")
    //@Column(name = "username", nullable = false, unique = true)
    private String username;

    //@Size(min = 8, max = 32, message = "password length should be between 8 and 32 characters")
    //@Column(name = "password", nullable = false)
    private String password;

}
