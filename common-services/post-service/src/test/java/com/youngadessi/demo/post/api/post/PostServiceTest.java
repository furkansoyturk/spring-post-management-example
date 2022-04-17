package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.PostDTO;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RequiredArgsConstructor
@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save() {
            PostDTO postDTO = new PostDTO();
            postDTO.setContent("getir");
            postDTO.setCreatedByName("efe");
            postService.save(postDTO);

        PostDTO byId = postService.findById(1L);
        if(Objects.equals(postDTO.getContent(), byId.getContent())){
            assertThat(Boolean.TRUE).isTrue();
        } else {
            assertThat(Boolean.FALSE).isTrue();
        }
    }
}
