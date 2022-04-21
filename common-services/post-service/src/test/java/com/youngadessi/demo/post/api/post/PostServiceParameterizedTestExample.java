package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import com.youngadessi.demo.post.model.post.PostMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceParameterizedTestExample {

    @Mock
    PostService postService;

    private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);

    @ParameterizedTest
    @ValueSource(longs = {1,2,4,5,6})
    void findById(Long input){

        Post post1 = new Post();
        post1.setContent("1");
        post1.setId(1L);

        Post post2 = new Post();
        post2.setContent("2");
        post2.setId(2L);

        Post post5 = new Post();
        post5.setContent("5");
        post5.setId(5L);

        List<Post> postList = new ArrayList<>();
        Collections.addAll(postList, post1, post2, post5);

        when(postService.findById(input)).then((invocationOnMock -> {
            PostDTO postDTO = new PostDTO();

            for (Post post : postList) {
               if( post.getId() == input.intValue()){
                    postDTO = POST_MAPPER.postToPostDTO(post);
               }
            }
            return postDTO;
        }));


       String postContent = postService.findById(input).getContent();

       assert input.toString().equals(postContent): "Post not found with given id : " + input.intValue();



//        try {
//            assert input.toString().equals(postContent): "Post not found with given id : " + input.intValue();
//
//       } catch (AssertionError error){
//           System.out.println(error);
//       }

//        assertAll("Should return post content",
//                () -> assertEquals("post1", postContent),
//                () -> assertEquals("post2", postContent),
//                () -> assertEquals("post5", postContent)
//        );

    }
}
