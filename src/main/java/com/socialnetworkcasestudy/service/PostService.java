package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(long id);

    Post save(Post post);

    void delete(int id);
}
