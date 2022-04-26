package com.youngadessi.demo.post.model.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class customDTO {

    private String createdByName;

    private String content;

    public customDTO(String content, String createdByName){
        this.content = content;
        this.createdByName = createdByName;
    }

}
