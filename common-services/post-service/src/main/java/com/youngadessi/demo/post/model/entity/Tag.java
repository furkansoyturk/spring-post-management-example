package com.youngadessi.demo.post.model.entity;

import com.youngadessi.demo.model.BaseEntity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_tag")
public class Tag extends BaseEntity {

    @Column(name = "tag_name")
    private String tagName;

}
