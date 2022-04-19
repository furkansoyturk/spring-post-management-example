package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.PostDTO;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;


@RequiredArgsConstructor
@SpringBootTest
public class PostServiceTest {

    @MockBean
    PostService postService;

    @Test
    void save() {
        PostDTO postDTO = new PostDTO();
        postDTO.setContent("aaaaa");
        postDTO.setCreatedByName("bbbb");

        when(postService.save(postDTO)).thenReturn(Boolean.TRUE);
        assert(postService.save(postDTO)).equals(Boolean.TRUE);
    }

    @Test
    void findById(){
        PostDTO postDTO = new PostDTO();
        postDTO.setContent("qqqqq");
        postDTO.setCreatedByName("aaaa");

        when(postService.findById(1L)).thenReturn(postDTO);
        assert ("aaaa").equals(postService.findById(1l).getCreatedByName());
    }
}
