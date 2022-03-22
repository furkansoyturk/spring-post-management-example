package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import com.youngadessi.demo.post.model.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Boolean> savePost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@PathVariable( "id" ) Long id, @RequestBody PostDTO postDTO) {
        return postService.update(id,postDTO);
    }

//    @PostMapping
//    public boolean updateAll(List<PostDTO> postDTOList){
//        return true;
//    }

    @GetMapping(value = "/last-five-days")
    public List<Post> findLastFiveDay(){
        return postService.findLastFiveDays();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        postService.deleteById(id);
    }
}
