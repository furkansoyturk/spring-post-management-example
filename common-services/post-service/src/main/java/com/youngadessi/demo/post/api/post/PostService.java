package com.youngadessi.demo.post.api.post;

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CommentRepository commentRepository;

    private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);
    private static final CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);

    public Boolean save(PostDTO postDTO){
        postRepository.save(POST_MAPPER.postDTOToPost(postDTO));
        return Boolean.TRUE;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }


    public Post update(Long id, PostDTO postDTO){
        Post post = this.findById(id);
        postRepository.save(POST_MAPPER.mergePostDTOWithPost(post,postDTO));
        return this.findById(id);
    }

    public List<Post> findLastFiveDays(){
        return postRepository.findLastFiveDays();
    }


    public Boolean assignTagsToPost(Long postId, List<Long> tagId){
        Optional<Post> post = postRepository.findById(postId);
        List<Tag> allTagById = tagRepository.findAllById(tagId);

        post.get().setPostTags(allTagById);
        postRepository.save(post.get());

        return Boolean.TRUE;
    }

    public Boolean deleteTagsFromPost(Long postId, List<Long> tagsToDelete){
        Optional<Post> post = postRepository.findById(postId);

        List<Tag> allTagById = tagRepository.findAllById(tagsToDelete);

        int postTagCount = post.get().getPostTags().size();
        List<Tag> postTags = Arrays.asList(new Tag[postTagCount]);

        for (int i = 0; i < postTags.size(); i++) {
            Tag existingTag = postTags.get(i);
            for (int j = 0; j < allTagById.size(); j++) {
                Tag tagToDelete = allTagById.get(j);
                if( existingTag != null && existingTag.getId().intValue() == tagToDelete.getId().intValue()) {
                    System.out.println("eşit değil: " + existingTag.getId().intValue() + " : " + tagToDelete.getId().intValue());
                    postTags.remove(existingTag);
                }
            }
        }


        post.get().setPostTags(postTags);
        postRepository.save(post.get());

        return Boolean.TRUE;
    }


    public Boolean commentToPost(Long postId, CommentDTO commentDTO){

        Post postById = this.findById(postId);

        Comment comment = COMMENT_MAPPER.commentDTOTOComment(commentDTO);
        comment.setPost(postById);
        commentRepository.save(comment);

        return Boolean.TRUE;
    }
}
