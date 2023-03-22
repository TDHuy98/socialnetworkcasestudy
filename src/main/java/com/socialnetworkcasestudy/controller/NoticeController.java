package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Likes;
import com.socialnetworkcasestudy.model.Notifications;
import com.socialnetworkcasestudy.service.LikeService;
import com.socialnetworkcasestudy.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;


    @GetMapping
    public List<Notifications> showAllUser() {
        return noticeService.findAll();
    }

    //Thêm
    @PostMapping
    public void create(@RequestBody Notifications notifications) {
        noticeService.save(notifications);
    }

    //Hiển thị
    @GetMapping("/{id}")
    public List<Notifications> showNoticationByIdUser(@PathVariable Long id) {
        return noticeService.findByIdUser(id);
    }


    //Delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        noticeService.delete(id);
    }
}
