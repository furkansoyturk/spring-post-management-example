package com.youngadessi.demo.post.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Post")
//@Table(name = "post")
public class Post extends BaseEntity {

    //@Column(name = "created_by_name")
    private String createdByName;

    //@Column(name = "content")
    private String content;

}
