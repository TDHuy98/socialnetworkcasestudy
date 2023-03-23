package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.dto.PostModifierDto;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.PostStatus;

import java.util.List;

public interface PostService {

    List<PostDto> findAllByUser_Id(Long id);

    PostCreationDto createPost(PostCreationDto postCreationDto);

    void delete(Long id);


    PostModifierDto findById(Long id);

    List<PostDto> allPost();

    List<PostDto> feed(Long id);

    List<Post> findAll();

    Post changeStatus(long id, PostStatus postStatus);
}
