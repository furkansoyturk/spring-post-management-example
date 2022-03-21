package com.youngadessi.demo.post.model.mapper;

import com.youngadessi.demo.post.model.entity.Post;
import com.youngadessi.demo.post.model.dto.PostDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {

    PostDTO toDto(Post entity);

    Post toEntity(PostDTO dto);

}
