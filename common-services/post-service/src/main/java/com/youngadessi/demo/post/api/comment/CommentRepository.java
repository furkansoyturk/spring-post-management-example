package com.youngadessi.demo.post.api.comment;

import com.youngadessi.demo.post.model.comment.Comment;
import com.youngadessi.demo.post.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

//    @Query(value = "SELECT post_schema.tbl_post.id," +
//            "post_schema.tbl_post.created_by," +
//            " post_schema.tbl_post.created_date_time," +
//            " post_schema.tbl_post.updated_by," +
//            " post_schema.tbl_post.updated_date_time," +
//            " post_schema.tbl_post.version," +
//            " post_schema.tbl_post.content," +
//            " post_schema.tbl_post.created_by_name" +
//            "FROM post_schema.tbl_post " +
//            "LEFT OUTER JOIN post_schema.tbl_post_comment comment " +
//            "ON post_schema.tbl_post.id = comment.post_id " +
//            "WHERE comment.comment_text " +
//            "LIKE %:commentText% " +
//            "GROUP BY post_schema.tbl_post.id", nativeQuery = true)
//    List<Post> findPostsByCommentText(@Param("commentText") String commentText);

    @Query(value = "SELECT p FROM Post p LEFT OUTER JOIN Comment c ON p.id = c.post.id where c.commentText LIKE CONCAT('%',:commentText,'%') GROUP BY p.id")
    List<Post> findPostsByCommentText(@Param("commentText") String commentText);

}

//    @Query(value = "SELECT * FROM post_schema.tbl_post_comment m WHERE m.comment_text LIKE %:commentText%", nativeQuery = true)

