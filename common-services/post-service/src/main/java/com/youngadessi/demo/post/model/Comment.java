package com.youngadessi.demo.post.model;

import com.youngadessi.demo.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tbl_post_comment")
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "created_by_name")
    private String createdByName;

    @Column(name = "comment_date_time")
    private LocalDateTime commentDateTime;

}
