package com.youngadessi.demo.post.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToMany;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

}
