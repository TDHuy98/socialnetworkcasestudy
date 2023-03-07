package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAllByUser_Id(Long id);

    public Post save(Post post);

    void delete(Long id);


}
