package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.dto.PostModifierDto;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.PostStatus;
import com.socialnetworkcasestudy.service.FriendService;
import com.socialnetworkcasestudy.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*")
public class PostController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    FriendService friendService;

    @GetMapping("/{id}")
    public List<PostDto> feed(@PathVariable Long id) {
        return postService.findAllByUser_Id(id);
    }

    @PostMapping
    public ResponseEntity<PostCreationDto> postStatus(@RequestBody PostCreationDto post){
        try {
            postService.createPost(post);
            return new ResponseEntity<>(post, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(post,HttpStatus.CONFLICT);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }


    @GetMapping("findById/{id}")
    public PostModifierDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @PutMapping("/delete/{id}")
    public Post delete(@PathVariable long id) {
        return postService.changeStatus(id, PostStatus.Delete);
    }
}
