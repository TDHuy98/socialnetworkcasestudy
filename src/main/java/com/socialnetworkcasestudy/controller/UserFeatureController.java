package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.CheckUserPass;
import com.socialnetworkcasestudy.dto.UserSetting;
import com.socialnetworkcasestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserFeatureController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserSetting> getUserInformation(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserUpdate(id));
    }

    @PostMapping("/setting")
    public UserSetting setting(@RequestBody UserSetting userSetting) {
        userService.updateUserInformation(userSetting);
        return userSetting;
    }

    @PostMapping("/changepassword")
    public boolean checkPassword(@RequestBody CheckUserPass checkUserPass){
        return userService.checkPasswordExisted(checkUserPass);
    }
}
