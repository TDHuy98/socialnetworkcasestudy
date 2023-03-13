package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @GetMapping("/comment/{id}")
    public List<Comment> list(@PathVariable Long id){
        return (List<Comment>) commentService.findAllById(id);
    }

    @PostMapping
    public Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }
}
