package com.socialnetworkcasestudy.controller;


import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.PostStatus;
import com.socialnetworkcasestudy.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostServiceImpl postService;
//    @GetMapping("/post/{id}")
//    public List<Post> list(@PathVariable Long id){
//        return (List<Post>) postService.findAllById(id);
//    }


    @GetMapping()
    public ResponseEntity<List<Post>> getAllPost(){
        return new ResponseEntity(postService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public Post save(@RequestBody Post post){
        return postService.save(post);
    }


    @PutMapping("/delete/{id}")
    public Post delete(@PathVariable Long id){
        Post post = postService.findById(id);
        post.setPostStatus(PostStatus.Delete);
        return postService.save(post);
    }



    @PutMapping("/create/{id}")
    public Post Create(@PathVariable Long id){
        Post post = postService.findById(id);
        post.setPostStatus(PostStatus.Friend);
        return postService.save(post);
    }
}
