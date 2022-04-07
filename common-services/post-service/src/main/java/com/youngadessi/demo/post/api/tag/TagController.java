package com.youngadessi.demo.post.api.tag;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.tag.TagDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping(value = "/save")
    public ResponseEntity<Boolean> save(@RequestBody TagDTO tagDTO){
        return new ResponseEntity<>(tagService.save(tagDTO), HttpStatus.CREATED);
    }





}
