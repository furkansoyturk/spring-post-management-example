package com.youngadessi.demo.post.api.comment;

import com.youngadessi.demo.post.model.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT * FROM post_schema.tbl_post_comment m WHERE m.comment_text LIKE %:commentText%", nativeQuery = true)
    List<Comment> findCommentsByCommentText(@Param("commentText") String commentText);}