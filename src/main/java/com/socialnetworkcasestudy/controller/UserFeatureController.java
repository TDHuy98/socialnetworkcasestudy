package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.UserPass;
import com.socialnetworkcasestudy.dto.UserSetting;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserFeatureController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> showAllUser() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserSetting> getUserInformation(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserUpdate(id));
    }

    @PostMapping("/setting")
    public UserSetting setting(@RequestBody UserSetting userSetting) {
        userService.updateUserInformation(userSetting);
        return userSetting;
    }

    @PostMapping("/checkpassword")
    public boolean checkPassword(@RequestBody UserPass userPass){
        return userService.checkPasswordExisted(userPass);
    }

    @PutMapping("/changepassword")
    public void changeUserPassword(@RequestBody UserPass userPass) {
        userService.changeUserPassword(userPass);
    }
}
