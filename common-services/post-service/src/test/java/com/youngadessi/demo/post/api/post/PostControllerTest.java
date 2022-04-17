package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.PostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PostControllerTest {

    @Autowired
    PostService postService;

    @Test
    void save() {
        PostDTO postDTO = new PostDTO();
        postDTO.setContent("araba");
        postDTO.setCreatedByName("err");

        Boolean isPostSaved = postService.save(postDTO);
        assertThat(isPostSaved).isTrue();
    }
}
