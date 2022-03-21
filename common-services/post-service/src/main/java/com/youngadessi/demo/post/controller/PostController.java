package com.youngadessi.demo.post.controller;

//import com.youngadessi.demo.post.model.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
//import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    //private final PostService postService;
    //private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);

}
