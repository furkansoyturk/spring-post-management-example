package com.youngadessi.demo.user.model.mapper;

import com.youngadessi.demo.user.model.entity.User;
import com.youngadessi.demo.user.model.dto.UserDataDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapstructMapper {

    UserDataDTO toDto(User entity);

    User toEntity(UserDataDTO dto);

}
