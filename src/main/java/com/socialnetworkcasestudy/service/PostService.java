package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllByUser_Id(Long id);

    Post save(Post post);

    void delete(Long id);

    Post findById(Long id);
}
