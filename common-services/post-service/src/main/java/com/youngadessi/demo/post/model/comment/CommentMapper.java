package com.youngadessi.demo.post.model.comment;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
@Component
public interface CommentMapper {

    Comment  commentDTOTOComment(CommentDTO commentDTO);

    Comment dtoToEntity(@MappingTarget Comment comment, CommentDTO commentDTO);

}
