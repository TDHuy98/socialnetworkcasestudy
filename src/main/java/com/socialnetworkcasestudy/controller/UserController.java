package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.service.UserService;
import com.socialnetworkcasestudy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/{username}")
    public ResponseEntity<List<User>> getAllUser(@PathVariable String username){
        return new ResponseEntity<>(userService.findUsersBySearchName(username), HttpStatus.OK);
    }


}
