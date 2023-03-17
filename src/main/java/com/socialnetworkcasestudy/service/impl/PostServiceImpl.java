package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.dto.PostModifierDto;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.PostStatus;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import com.socialnetworkcasestudy.service.AuthService;
import com.socialnetworkcasestudy.service.PostService;
import com.socialnetworkcasestudy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collections;
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
    @Autowired
    private FriendServiceImpl friendService;

    public List<PostDto> findAllByUser_Id(Long id) {
        User userFound = userService.findUserById(id);
        List<PostDto> postOfUser = new java.util.ArrayList<>(userPostRepository.findAllByUsers_Id(id).stream().map(this::postToPostDto)
                .toList())
                ;

        postOfUser.forEach(u->u.setFirstname(userFound.getFirstName()));
        postOfUser.forEach(u->u.setLastname(userFound.getLastName()));
        Collections.reverse(postOfUser);
        return postOfUser;
    }

    @Override
    public PostCreationDto createPost(PostCreationDto postCreationDto) {
        Post postCreation = postCreationDtoToPost(postCreationDto);
        postCreation.setCreatedAt(Instant.now());
        userPostRepository.save(postCreation);
        return postCreationDto;
    }

    @Override
    public void delete(Long id) {
        userPostRepository.deleteById(id);
    }

    public PostModifierDto findById(Long id) {
        return  postToPostModifierDto(userPostRepository.findById(id).get()) ;
    }


    private Post postModifierDtoToPost(PostModifierDto postModifierDto) {
        return modelMapper.map(postModifierDto, Post.class);
    }

    private PostModifierDto postToPostModifierDto(Post post) {
        return modelMapper.map(post, PostModifierDto.class);
    }

    private Post postCreationDtoToPost(PostCreationDto postCreationDto) {
        return modelMapper.map(postCreationDto, Post.class);
    }
    @Override
    public List<PostDto> allPost(){
      return userPostRepository.findAll().stream().map(this::postToPostDto).toList();
    }

    private PostDto postToPostDto(Post post){
        return modelMapper.map(post, PostDto.class);
    }
    private Post PostDtoToPost(PostDto postDto){
        return modelMapper.map(postDto,Post.class);
    }

    public Post save(Post post){
        return userPostRepository.save(post);
    }

    public Post changeStatus(long id, PostStatus postStatus) {
        Post post= postModifierDtoToPost(findById(id)) ;
        post.setPostStatus(postStatus);
        return save(post);
    }



}
