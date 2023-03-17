package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.model.Post;

import java.util.List;

public interface PostService {

    PostCreationDto createPost(PostCreationDto postCreationDto);

    void delete(Long id);



    List<PostDto> allPost();

    List<Post> findAll();
}
