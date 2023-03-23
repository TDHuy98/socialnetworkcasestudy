package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.FriendTestDto;
import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.dto.PostModifierDto;
import com.socialnetworkcasestudy.exception.ResourceNotFoundException;
import com.socialnetworkcasestudy.model.*;
import com.socialnetworkcasestudy.repository.UserFriendRepository;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import com.socialnetworkcasestudy.service.PostService;
import com.socialnetworkcasestudy.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFriendRepository userFriendRepository;

    @Override
    public List<PostDto> findAllByUser_Id(Long id) {
        User userFound = userService.findUserById(id);
        List<PostDto> postOfUser = new java.util.ArrayList<>(userPostRepository.findAllByUsers_Id(id).stream().map(this::postToPostDto)
                .toList());
        postOfUser.forEach(u -> u.setProfile(userFound.getProfile()));
        postOfUser.forEach(u -> u.setFirstName(userFound.getFirstName()));
        postOfUser.forEach(u -> u.setMiddleName(userFound.getMiddleName()));
        postOfUser.forEach(u -> u.setLastName(userFound.getLastName()));
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

    @Override
    public PostModifierDto findById(Long id) {
        return postToPostModifierDto(userPostRepository.findById(id).get());
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
    public List<PostDto> allPost() {
        return userPostRepository.findAll().stream().map(this::postToPostDto).toList();
    }

    @Override
    public List<PostDto> feed(Long id) {
        User loggedInUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        userPostRepository.findAllByUsers_Id(id).stream().map(this::postToPostDto).toList();
        List<Long> friendIdList = new ArrayList<>();
        List<PostDto> postDtos = new ArrayList<>();
        userFriendRepository.findBySourceIdAndFriendStatus(id, FriendshipStatus.Active).stream().map(this::friendToFriendTestDto).forEach(u -> friendIdList.add(friendIdList.size(), u.getTargetId()));
        friendIdList.forEach(u -> postDtos.addAll(userPostRepository.findAllByUsers_Id(u.longValue()).stream().map(this::postToPostDto).toList()));
        postDtos.forEach(post -> {modelMapper.map(userRepository.findById(post.getUserId()).get(),post);});

        return postDtos;
    }

//    private TypeMap<User, PostDto> userPostDtoTypeMap = modelMapper.createTypeMap(User.class, PostDto.class);

    private FriendTestDto friendToFriendTestDto(Friend friend) {
        return modelMapper.map(friend, FriendTestDto.class);
    }

    private PostDto postToPostDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    private PostDto userToPostDto(User user) {
        return modelMapper.map(user, PostDto.class);
    }

    private Post postDtoToPost(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }

    @Override
    public List<Post> findAll() {
        return userPostRepository.findAll();
    }

    public Post save(Post post) {
        return userPostRepository.save(post);
    }

    @Override
    public Post changeStatus(long id, PostStatus postStatus) {
        Post post = postModifierDtoToPost(findById(id));
        post.setPostStatus(postStatus);
        return save(post);
    }


}
