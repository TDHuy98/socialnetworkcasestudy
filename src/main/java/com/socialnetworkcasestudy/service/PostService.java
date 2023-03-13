package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post save(Post post);

    void delete(Long id);

    Post findById( Long id);






}
