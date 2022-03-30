package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import com.youngadessi.demo.post.model.comment.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
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
    public ResponseEntity<List<PostDTO>> findAll(@RequestParam(name = "pageSize",defaultValue = "1") Integer pageSize){
        return new ResponseEntity<>(postService.findAll(pageSize), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable( "id" ) Long id, @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.update(id,postDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/comments/{comment-text}")
    public ResponseEntity<List<PostDTO>> findPostsByComment(@PathVariable("comment-text") String commentText){
        List<PostDTO> postDTOList = postService.findPostsByComment(commentText);
        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    //TODO fix this return
    @GetMapping(value = "/last-five-days")
    public ResponseEntity<List<PostDTO>> findLastFiveDay(@RequestParam(name = "pageNumber", defaultValue = "0") Integer PageNumber,@RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        return new ResponseEntity<>(postService.findLastFiveDays(pageSize), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        postService.deleteById(id);
    }


    @PostMapping(value = "/{id}/tags")
    public ResponseEntity<Boolean> assignTags(@PathVariable Long id, @RequestBody List<Long> tagIdList){
        return new ResponseEntity<>(postService.assignTags(id,tagIdList), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}/tags")
    public ResponseEntity<Boolean> deleteTags(@PathVariable Long id, @RequestBody List<Long> tagIdList){
        return new ResponseEntity<>(postService.deleteTags(id,tagIdList), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}/comments")
    public ResponseEntity<Boolean> comment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(postService.comment(id,commentDTO), HttpStatus.CREATED);
    }

}
