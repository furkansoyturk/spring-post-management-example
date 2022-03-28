package com.youngadessi.demo.post.model.post;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
@Component
public interface PostMapper {

    PostDTO postToPostDTO(Post post);

    Post postDTOToPost(PostDTO dto);

    Post mergePostDTOWithPost(@MappingTarget Post post, PostDTO postDTO);

    List<Post> mergePostDTOListWithPostList(@MappingTarget List<Post> postList, List<PostDTO> postDTOList);

    List<PostDTO> toPostDTO(List<Post> postList);


}
