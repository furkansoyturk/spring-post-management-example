package com.youngadessi.demo.post.model.tag;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TagMapper {

    TagDTO tagToTagDTO(Tag tag);

    Tag tagDTOToTag(TagDTO tagDTO);

    Tag mergeTagDTOWithTag(@MappingTarget Tag tag, TagDTO tagDTO);

    List<Tag> mergeTagDTOListWithTagList(@MappingTarget List<Tag> tagList, List<TagDTO> tagDTOList);



}
