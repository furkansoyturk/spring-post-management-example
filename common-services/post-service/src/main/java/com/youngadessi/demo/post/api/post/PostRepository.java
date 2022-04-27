package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.customDTOInterface;
import com.youngadessi.demo.post.model.post.customDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


    @Query( value = "SELECT * FROM post_schema.tbl_post WHERE created_date_time > cast(now() as DATE) - 50",
//            countQuery = "select count(id) from post_schema.tbl_post where created_date_time > cast(now() as DATE) - 50",
            nativeQuery = true)
    Page<Post> findLastFiveDays(Pageable pageable);

//    @Query(value = "SELECT p FROM Post p WHERE p.content like %:content%")
//    Page<Post> findAllPostByContent(@Param("content") String content, Pageable pageable);
    @Query(value = "SELECT new com.youngadessi.demo.post.model.post.customDTO (p.content, p.createdByName)  FROM Post p WHERE p.content like %:content%")
    Page<customDTO> findAllByContent(@Param("content") String content, Pageable pageable);

    @Query(value = "SELECT p.created_by_name AS createdByName, p.content  FROM post_schema.tbl_post p WHERE p.created_by_name like %:createdByName%", nativeQuery = true)
    Page<customDTOInterface> findAllCreatedByName(@Param("createdByName") String createdByName, Pageable pageable);

}
