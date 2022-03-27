package com.youngadessi.demo.post.api.comment;


import com.youngadessi.demo.post.model.comment.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PutMapping(value = "{id}/update")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.update(id,commentDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
      commentService.deleteById(id);
    }

}
