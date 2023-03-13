package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import com.socialnetworkcasestudy.service.AuthService;
import com.socialnetworkcasestudy.service.PostService;
import com.socialnetworkcasestudy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserPostRepository userPostRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @Override
    public List<Post> findAllByUser_Id(Long id) {
        return userPostRepository.findAllByUsers_Id(id);
    }

    @Override
    public PostCreationDto createPost(PostCreationDto postCreationDto) {
        UserDetails loggedInUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postCreationDto.setUserId(userService.findUserByUserName(loggedInUser.getUsername()).get().getId());
        Post postCreation = postCreationDtoToPost(postCreationDto);
        postCreation.setCreatedAt(Instant.now());
        userPostRepository.save(postCreation);
        return postCreationDto;
    }

    @Override
    public void delete(Long id) {
        userPostRepository.deleteById(id);
    }

    @Override
    public Post findById(Long id) {
        return userPostRepository.findById(id).get();
    }

    private Post postCreationDtoToPost(PostCreationDto postCreationDto) {
        return modelMapper.map(postCreationDto, Post.class);
    }
}
