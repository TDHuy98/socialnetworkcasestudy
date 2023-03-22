package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Message;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/message")
public class MessageController {
   @Autowired
    MessageServiceImpl messageService;


    @GetMapping("/{source}&{target}")
    public ResponseEntity<List<Message>> messageList(@PathVariable Long source, @PathVariable Long target) {
        return new ResponseEntity<>(messageService.findAllBySourceAndTarget(source,target), HttpStatus.OK);
    }

    @GetMapping("/listFriend/{source_id}")
    public ResponseEntity<HashSet<User>> listFriend (@PathVariable Long source_id) {
        return new ResponseEntity<>(messageService.ListFriend(source_id),HttpStatus.OK);
    }


}
