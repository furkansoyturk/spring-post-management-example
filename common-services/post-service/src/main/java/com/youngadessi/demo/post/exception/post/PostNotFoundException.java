package com.youngadessi.demo.post.exception.post;

public class PostNotFoundException  extends  RuntimeException{
    public PostNotFoundException (Long id) {
        super("Could not find post " + id);
    }
}
