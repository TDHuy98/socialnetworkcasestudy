package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.FriendDto;
import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.RelationshipType;
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
    private FriendService friendService;


    @GetMapping("/Active/{id}")
    public List<FriendDto> showAllActiveUser(@PathVariable Long id) {
        return friendService.getFriendListByUserIdStatusType(id,FriendshipStatus.Active, RelationshipType.Normal);
    }
    @GetMapping("/Sender/{id}")
    public List<FriendDto> showAllSenderUser(@PathVariable Long id) {
        return friendService.getFriendListByUserIdStatusType(id,FriendshipStatus.Sender,RelationshipType.Normal);
    }
    @GetMapping("/New/{id}")
    public List<FriendDto> showAllNewUser(@PathVariable Long id) {
        return friendService.getFriendListByUserIdStatusType(id,FriendshipStatus.New,RelationshipType.Normal);
    }
    @GetMapping("/Block/{id}")
    public List<FriendDto> showAllBlockUser(@PathVariable Long id) {
        return friendService.getFriendListByUserIdStatusType(id,FriendshipStatus.Block,RelationshipType.Normal);
    }

    //    Thêm
    @PostMapping
    public void create(@RequestBody Friend friend) {
        friendService.save(friend);
    }

    //    Hiển thị
    //    Sửa user

    @PutMapping("/cancer")
    public void requestCancer(@RequestBody Friend friend) {
        friendService.requestCancer(friend);
    }

    //    Block user
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        friendService.delete(id);
    }
}
