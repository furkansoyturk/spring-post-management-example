package com.youngadessi.demo.user.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Data
public class UserDataDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
