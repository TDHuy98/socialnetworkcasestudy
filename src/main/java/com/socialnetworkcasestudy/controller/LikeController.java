package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Likes;
import com.socialnetworkcasestudy.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;


    @GetMapping
    public List<Likes> showAllUser() {
        return likeService.findAll();
    }

    //    Thêm
    @PostMapping
    public void create(@RequestBody Likes likes) {
        likeService.save(likes);
    }

    //    Hiển thị
    @GetMapping("/{id}")
    public List<Likes> showLikeByIdPost(@PathVariable int id) {
        return likeService.findByPostId(id);
    }

    //coutLike
    @GetMapping("/countLike/{id}")
    public Long countLikeByPost(@PathVariable int id){
        return likeService.coutLikeByPostId(id);
    }

    //   Unlike
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        likeService.delete(id);
    }
}
