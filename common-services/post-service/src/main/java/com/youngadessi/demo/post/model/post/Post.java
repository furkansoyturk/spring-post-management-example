package com.youngadessi.demo.post.model.post;

import com.youngadessi.demo.model.BaseEntity;
import com.youngadessi.demo.post.model.tag.Tag;
import com.youngadessi.demo.post.model.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_post")
public class Post extends BaseEntity {

    @Column(name = "created_by_name")
    private String createdByName;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> postComments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_post_tags",
            joinColumns = @JoinColumn(name = "post_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id")
    )
    private List<Tag> postTags;

}
