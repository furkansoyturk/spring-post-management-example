package com.youngadessi.demo.user.model.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class UserDataDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
