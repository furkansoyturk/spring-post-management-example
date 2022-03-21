package com.youngadessi.demo.post.controller;

import com.youngadessi.demo.post.model.dto.TagDTO;
import com.youngadessi.demo.post.model.entity.Tag;
import com.youngadessi.demo.post.model.mapper.TagMapper;
import com.youngadessi.demo.post.service.TagService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;

    private static final TagMapper TAG_MAPPER = Mappers.getMapper(TagMapper.class);

    @GetMapping
    public List<TagDTO> getAllComments() {
        List<Tag> allComments = tagService.getAllTags();
        return allComments.stream().map(TAG_MAPPER::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public TagDTO getComment(@PathVariable @Min(1) Long id) {
        return TAG_MAPPER.toDto(tagService.getTag(id));
    }

    @PostMapping
    public void saveComment(@Valid @RequestBody TagDTO tag) {
        tagService.addTag(TAG_MAPPER.toEntity(tag));
    }

    @PutMapping
    public TagDTO updateComment(@Valid @RequestBody Tag tag) {
        if (tag.getId() == null) {
            throw new RuntimeException("Tag id can not be null for update!");
        }
        return TAG_MAPPER.toDto(tagService.updateTag(tag));
    }

    @DeleteMapping
    public boolean deleteComment(@RequestParam @Min(1) Long id) {
        return tagService.deleteTag(id);
    }

}
