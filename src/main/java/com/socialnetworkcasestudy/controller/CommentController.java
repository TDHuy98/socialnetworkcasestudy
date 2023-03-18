package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.CommentDto;
import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.service.CommentService;
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
    public List<CommentDto> showAllCmt() {
        return commentService.findAll();
    }
    @GetMapping("/{id}")
    public Comment showById(Long id) {
        return commentService.findById(id);
    }

    //    Thêm
    @PostMapping
    public void create(@RequestBody Comment comment) {
        commentService.save(comment);
    }

    //    Hiển thị



    //   Xoácmt
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        commentService.delete(id);
    }
}
