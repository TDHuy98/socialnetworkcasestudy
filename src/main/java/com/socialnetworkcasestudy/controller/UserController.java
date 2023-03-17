package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.service.UserService;
import com.socialnetworkcasestudy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //Hiển thị tất cả user
    @GetMapping
    public List<User> showAllUser() {
        return userService.findAll();
    }

    //    Thêm user
    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    //    Hiển thị user muốn thêm
    @GetMapping("/{id}")
    public User showUserByID(@PathVariable int id) {
        return userService.findById(id);
    }

    //Lấy ra list các id fr của user đang đăng nhập



    //    Block user
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.delete(id);
    }
}
