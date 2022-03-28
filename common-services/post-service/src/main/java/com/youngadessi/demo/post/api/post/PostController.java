package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import com.youngadessi.demo.post.model.comment.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

//TODO should return DTOs

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@PathVariable( "id" ) Long id, @RequestBody PostDTO postDTO) {
        return postService.update(id,postDTO);
    }

    @GetMapping(value = "/comments/{comment-text}")
    public ResponseEntity<List<PostDTO>> findPostsByComment(@PathVariable("comment-text") String commentText){
        List<PostDTO> postDTOList = postService.findPostsByComment(commentText);
        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/last-five-days")
    public List<Post> findLastFiveDay(){
        return postService.findLastFiveDays();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        postService.deleteById(id);
    }


    @PostMapping(value = "/{id}/tags")
    public ResponseEntity<Boolean> assignTagToPost(@PathVariable Long id, @RequestBody List<Long> tagIdList){
        return new ResponseEntity<>(postService.assignTagsToPost(id,tagIdList), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}/tags")
    public ResponseEntity<Boolean> deleteTagsFromPost(@PathVariable Long id, @RequestBody List<Long> tagIdList){
        return new ResponseEntity<>(postService.deleteTagsFromPost(id,tagIdList), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}/comments")
    public ResponseEntity<Boolean> comment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(postService.comment(id,commentDTO), HttpStatus.CREATED);
    }

}
