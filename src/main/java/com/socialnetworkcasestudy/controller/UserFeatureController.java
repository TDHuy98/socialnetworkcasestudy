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
@RequestMapping("/api/v1/user-setting")
@CrossOrigin("*")
public class UserFeatureController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserSetting> getUserInformation(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserUpdate(id));
    }

    @PutMapping("/setting")
    public ResponseEntity<UserSetting> setting(@RequestBody UserSetting userSetting) {
        userService.updateUserInformation(userSetting);
        return ResponseEntity.ok(userSetting);
    }


    @PutMapping("/changepassword")
    public ResponseEntity<UserPass> changeUserPassword(@RequestBody UserPass userPass) {
        return ResponseEntity.ok(userService.changeUserPassword(userPass));
    }


}
