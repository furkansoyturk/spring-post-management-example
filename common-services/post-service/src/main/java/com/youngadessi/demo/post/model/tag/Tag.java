package com.youngadessi.demo.post.model.tag;

import com.youngadessi.demo.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tag")
public class Tag extends BaseEntity {

    @Column(name = "tag_name")
    private String tagName;
}
