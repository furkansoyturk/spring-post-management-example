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
@Entity(name = "Tag")
//@Table(name = "tag")
public class Tag extends BaseEntity {

    //@Column(name = "tag_name")
    private String tagName;

    //@Column(name = "version")
    private  Integer version;

}
