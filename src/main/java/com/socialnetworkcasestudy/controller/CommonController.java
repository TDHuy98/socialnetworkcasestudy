package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.UserDto;
import com.socialnetworkcasestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/common")
@CrossOrigin("*")
public class CommonController {
    @Autowired
    private UserService userService;

    @PostMapping("/{searchValue}")
    public ResponseEntity<List<UserDto>> searchUser(@PathVariable String searchValue) {
        return ResponseEntity.ok(userService.searchUser(searchValue));
    }

    @PostMapping("/enable-search/{userId}")
    public ResponseEntity<String> enableSearchable(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.enableSearch(userId));
    }

    @PostMapping("/disable-search/{userId}")
    public ResponseEntity<String> disableSearchable(@PathVariable Long userId){
        return ResponseEntity.ok(userService.disableSearch(userId));
    }
}
