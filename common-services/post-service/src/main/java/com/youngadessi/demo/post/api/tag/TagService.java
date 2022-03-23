package com.youngadessi.demo.post.api.tag;

import com.youngadessi.demo.post.api.post.PostRepository;
import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.tag.Tag;
import com.youngadessi.demo.post.model.tag.TagDTO;
import com.youngadessi.demo.post.model.tag.TagMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostRepository postRepository;

    private static final TagMapper TAG_MAPPER = Mappers.getMapper(TagMapper.class);

    public Boolean save(TagDTO tagDTO){
        tagRepository.save(TAG_MAPPER.tagDTOToTag(tagDTO));
        return Boolean.TRUE;
    }


}
