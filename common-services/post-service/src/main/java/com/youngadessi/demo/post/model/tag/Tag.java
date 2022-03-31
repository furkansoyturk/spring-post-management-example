package com.youngadessi.demo.post.model.tag;

import com.youngadessi.demo.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tbl_tag")
public class Tag extends BaseEntity {

    @Column(name = "tag_name")
    private String tagName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(super.getId(), tag.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId());
    }
}
