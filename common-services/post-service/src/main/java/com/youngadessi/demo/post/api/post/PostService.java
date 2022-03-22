package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import com.youngadessi.demo.post.model.post.PostMapper;
import com.youngadessi.demo.post.model.post.PostRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService{

    @Autowired
    PostRepository postRepository;

    private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);


    public Boolean savePost(PostDTO postDTO){
        postRepository.save(POST_MAPPER.postDTOToPost(postDTO));
        return Boolean.TRUE;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }

    public Post update(Long id, PostDTO postDTO){
    // TODO: update post
        return POST_MAPPER.postDTOToPost(postDTO);
    }





}
