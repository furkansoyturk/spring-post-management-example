package com.youngadessi.demo.post.model.comment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDTO {

    private String commentText;

    private String createdByName;

    private LocalDateTime commentDateTime;

}
