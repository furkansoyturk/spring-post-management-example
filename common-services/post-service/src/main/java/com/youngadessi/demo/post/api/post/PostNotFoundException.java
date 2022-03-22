package com.youngadessi.demo.post.api.post;

public class PostNotFoundException  extends  RuntimeException{
    public PostNotFoundException (Long id) {
        super("Could not find post " + id);
    }
}
