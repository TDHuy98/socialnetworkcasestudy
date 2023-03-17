package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.CommentDto;
import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.model.Likes;
import com.socialnetworkcasestudy.service.CommentService;
import com.socialnetworkcasestudy.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cmt")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping
    public List<Comment> showAllCmt() {
        return commentService.findAll();
    }

    //    Thêm
    @PostMapping
    public void create(@RequestBody Comment comment) {
        commentService.save(comment);
    }

    //    Hiển thị
    @GetMapping("/{id}")
    public List<CommentDto> showLikeByIdPost(@PathVariable Long id) {
        return commentService.findByPostId(id);
    }



    //   Xoácmt
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        commentService.delete(id);
    }
}
