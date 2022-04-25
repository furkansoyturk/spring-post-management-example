package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

//    @Query( value = "SELECT * FROM post_schema.tbl_post WHERE created_date_time > cast(now() as DATE) - 50  OFFSET :1 ROWS FETCH NEXT :pageSize ROWS ONLY", nativeQuery = true)
    @Query( value = "SELECT * FROM post_schema.tbl_post WHERE created_date_time > cast(now() as DATE) - 50",
            countQuery = "select count(id) from post_schema.tbl_post where created_date_time > cast(now() as DATE) - 50",
            nativeQuery = true)
    Page<Post> findLastFiveDays(@Param("pageSize") Pageable pageSize);

    @Query(value = "SELECT p FROM Post p WHERE p.content like %:content%")
    List<Post> findAllPostByContent(@Param("content") String content);

}
