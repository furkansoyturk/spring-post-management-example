package com.youngadessi.demo.post.controller;

//import com.youngadessi.demo.post.model.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
//import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    /*@Autowired
    private final PostService postService;*/
    //private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);

    @GetMapping
    public String sampleGet() {
        return "Return OK";
    }

    /*@GetMapping(value = "/all")
    public String getAll() {
        return "Take All";
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getSamplePost(@PathVariable Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }*/

    @GetMapping(value = "/get")
    public HttpStatus getSamplePost() {
        return HttpStatus.OK;
    }

}
