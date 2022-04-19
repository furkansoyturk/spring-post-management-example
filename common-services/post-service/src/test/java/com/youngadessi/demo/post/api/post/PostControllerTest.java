package com.youngadessi.demo.post.api.post;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostService postService;

    @Test
    void test() throws Exception {
        RequestBuilder request = get("/test/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assert ("test").equals(contentAsString);
    }

    @Test
    void findById() throws Exception {
        // post-service/posts/{id}
        PostDTO postDTO = new PostDTO();
        postDTO.setContent("post1");
        postDTO.setCreatedByName("ali");

        when(postService.findById(3L)).thenReturn(postDTO);

        RequestBuilder request = get("/post-service/posts/3")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
            .andExpect(content().json("{\"content\":\"post1\",\"createdByName\":\"ali\"}"))
            .andReturn();

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
    }
}
