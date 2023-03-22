package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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



    //    Hiển thị user muốn thêm
    @GetMapping("/{id}")
    public Optional<User> showUserByID(@PathVariable Long id) {
        return userService.findById(id);
    }

    //Lấy ra list các id fr của user đang đăng nhập



    //    Block user

}
