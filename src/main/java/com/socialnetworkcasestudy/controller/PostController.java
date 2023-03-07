package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/{id}")
    public List<Post> feed(@PathVariable Long id) {
        return postService.findAllByUser_Id(id);
    }

    @PostMapping
    public Post postStatus(@RequestBody Post post){
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }


}
