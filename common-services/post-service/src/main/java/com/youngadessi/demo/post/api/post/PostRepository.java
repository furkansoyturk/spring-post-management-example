package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "SELECT * FROM post_schema.tbl_post WHERE created_date_time > cast(now() as DATE) - 5;", nativeQuery = true)
    public List<Post> findLastFiveDays();
}
