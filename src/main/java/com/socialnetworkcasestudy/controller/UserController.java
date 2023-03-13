package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.service.UserService;
import com.socialnetworkcasestudy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;




    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

//    @DeleteMapping("{id}")
//    public void delete(@PathVariable Long id){
//        userService.delete(id);
//    }

//    @GetMapping("{id}")
//    public User showProfile(@PathVariable Long id){
//        return userService.findByUsername(id);
//    }

}
