package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/friends")
public class FriendController {
    @Autowired
    FriendService friendService;

    //Hiển thị tất cả user
    @GetMapping
    public List<Friend> showAllUser() {
        return friendService.findAll();
    }

    //    Thêm
    @PostMapping
    public void create(@RequestBody Friend friend) {
        friendService.save(friend);
    }

    //    Hiển thị
    @GetMapping("/{id}")
    public Optional<Friend> showAllFriendById(@PathVariable int id) {
        return friendService.findById(id);
    }

    @GetMapping("/listActiveFriends/{id}/{friendStatus}")
    public List<Friend> showAllActiveFriends(@PathVariable long id, FriendshipStatus friendshipStatus) {
        return friendService.getActiveFriendList(id,friendshipStatus);
    }
    @GetMapping("/listNewFriends/{id}")
    public List<Friend> showAllNewFriends(@PathVariable long id) {
        return friendService.getNewFriendList(id);
    }
    @GetMapping("/listBlockFriends/{id}")
    public List<Friend> showAllBlockFriends(@PathVariable long id) {
        return friendService.getBlockFriendList(id);
    }
    //    Sửa user
//    @PutMapping("/{id}")
//    public void saveEdit(@RequestBody User user) {
//        userService.save(user);
//
//    }

    //    Block user
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        friendService.delete(id);
    }
}
