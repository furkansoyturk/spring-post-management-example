package com.youngadessi.demo.user.model.mapper;

import com.youngadessi.demo.user.model.entity.User;
import com.youngadessi.demo.user.model.dto.UserDataDTO;

public class UserUserDefinedMapper {

    public static UserDataDTO toDto(User user) {
        UserDataDTO userDataDTO = new UserDataDTO();

        userDataDTO.setUsername(user.getUsername());
        userDataDTO.setPassword(user.getPassword());

        return userDataDTO;
    }

    public static User toEntity(UserDataDTO userDataDTO) {
        User user = new User();

        user.setUsername(userDataDTO.getUsername());
        user.setPassword(userDataDTO.getPassword());

        return user;
    }

}
