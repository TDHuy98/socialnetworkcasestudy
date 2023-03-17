package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.service.FriendService;
import com.socialnetworkcasestudy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;


    @GetMapping
    public List<Post> showAllUser() {
        return postService.findAll();
    }

    //    Thêm
    @PostMapping
    public void create(@RequestBody Post post) {
        postService.save(post);
    }

    //    Hiển thị
    @GetMapping("/{id}")
    public Optional<Post> showPostByIdPost(@PathVariable int id) {
        return Optional.ofNullable(postService.findById(id));
    }



    //    Block user
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        postService.delete(id);
    }
}
