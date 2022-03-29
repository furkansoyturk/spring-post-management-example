package com.youngadessi.demo.post.api.post;

import com.youngadessi.demo.post.api.comment.CommentRepository;
import com.youngadessi.demo.post.api.tag.TagRepository;
import com.youngadessi.demo.post.exception.post.PostNotFoundException;
import com.youngadessi.demo.post.model.comment.Comment;
import com.youngadessi.demo.post.model.comment.CommentDTO;
import com.youngadessi.demo.post.model.comment.CommentMapper;
import com.youngadessi.demo.post.model.post.Post;
import com.youngadessi.demo.post.model.post.PostDTO;
import com.youngadessi.demo.post.model.post.PostMapper;
import com.youngadessi.demo.post.model.tag.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CommentRepository commentRepository;

//    TODO: global exception

    private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);
    private static final CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);

    public Boolean save(PostDTO postDTO){
        postRepository.save(POST_MAPPER.postDTOToPost(postDTO));
        return Boolean.TRUE;
    }

    public List<PostDTO> findAll(Integer pageSize){

        Pageable firstPageWithTwoElements = PageRequest.of(0, pageSize);

        Page<Post> postPage = postRepository.findAll(firstPageWithTwoElements);
        List<Post> postList = postPage.getContent();
        List<PostDTO> postDTOList = POST_MAPPER.PostListToPostDTOList(postList);
        return postDTOList;
    }

    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }

    public PostDTO update(Long id, PostDTO postDTO){
        Post post = this.findById(id);
        Post updatedPost = postRepository.save(POST_MAPPER.mergePostDTOWithPost(post, postDTO));
        PostDTO updatedPostDTO = POST_MAPPER.postToPostDTO(updatedPost);
        return updatedPostDTO;
    }

    public List<PostDTO> findPostsByComment(String commentText){
        List<Post> postList = commentRepository.findPostsByCommentText(commentText);
        List<PostDTO> postDTOList = POST_MAPPER.PostListToPostDTOList(postList);

        return postDTOList;
    }

    public List<PostDTO> findLastFiveDays(){
        List<Post> lastFiveDays = postRepository.findLastFiveDays();
        List<PostDTO> postDTOList = POST_MAPPER.PostListToPostDTOList(lastFiveDays);

        return postDTOList;
    }

    public Boolean assignTags(Long postId, List<Long> tagId){
        Optional<Post> post = postRepository.findById(postId);
        List<Tag> allTagById = tagRepository.findAllById(tagId);

        post.get().setPostTags(allTagById);
        postRepository.save(post.get());

        return Boolean.TRUE;
    }

    public Boolean deleteTags(Long postId, List<Long> tagsToDelete){
        Optional<Post> post = postRepository.findById(postId);

        List<Tag> allTagById = tagRepository.findAllById(tagsToDelete);

        int postTagCount = post.get().getPostTags().size();
        List<Tag> postTags = Arrays.asList(new Tag[postTagCount]);

        for (int i = 0; i < postTags.size(); i++) {
            Tag existingTag = postTags.get(i);
            for (int j = 0; j < allTagById.size(); j++) {
                Tag tagToDelete = allTagById.get(j);
                if( existingTag != null && existingTag.getId().intValue() == tagToDelete.getId().intValue()) {
                    postTags.remove(existingTag);
                }
            }
        }
        post.get().setPostTags(postTags);
        postRepository.save(post.get());

        return Boolean.TRUE;
    }


    public Boolean comment(Long postId, CommentDTO commentDTO){

        Post postById = this.findById(postId);

        Comment comment = COMMENT_MAPPER.commentDTOTOComment(commentDTO);
        comment.setPost(postById);
        commentRepository.save(comment);

        return Boolean.TRUE;
    }


}
