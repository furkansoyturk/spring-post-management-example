package com.youngadessi.demo.post.model.comment;

import com.youngadessi.demo.model.BaseEntity;
import com.youngadessi.demo.post.model.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tbl_post_comment")
public class Comment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "created_by_name")
    private String createdByName;

    @Column(name = "comment_date_time")
    private LocalDateTime commentDateTime;

}
