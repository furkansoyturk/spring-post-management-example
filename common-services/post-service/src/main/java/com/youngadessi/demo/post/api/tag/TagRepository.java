package com.youngadessi.demo.post.api.tag;

import com.youngadessi.demo.post.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

    List<Tag> findByIdIn(List<Long> tagsToDelete);
}
