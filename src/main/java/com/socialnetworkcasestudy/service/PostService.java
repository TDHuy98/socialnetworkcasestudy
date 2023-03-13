package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllByUser_Id(Long id);

    PostCreationDto createPost(PostCreationDto postCreationDto);

    void delete(Long id);

    Post findById(Long id);
}
