package com.youngadessi.demo.post.api.post;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.youngadessi.demo.post.model.post.PostDTO;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    void test() throws Exception {
        // post-service/posts/test
        MvcResult result = mockMvc.perform(
                get("/posts/test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assert ("test").equals(result.getResponse().getContentAsString());
    }

    @Test
    void findById() throws Exception {
        // post-service/posts/{id}
        PostDTO postDTO = new PostDTO();
        postDTO.setContent("post1");
        postDTO.setCreatedByName("ali");

        String serializedPostDTO = new Gson().toJson(postDTO);

        when(postService.findById(3L)).thenReturn(postDTO);

        mockMvc.perform(get("/posts/3"))
                .andExpect(content()
                .json(serializedPostDTO))
                .andReturn();
    }
}
