package com.socialnetworkcasestudy.controller;


import com.socialnetworkcasestudy.model.MessageClass;
import com.socialnetworkcasestudy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Message")
public class MessageController {
    @Autowired
    MessageService messageService;


    @GetMapping
    public List<MessageClass> showAllMessage(@PathVariable Long id) {
        return messageService.findAllByUserId(id);
    }

    //Thêm
    @PostMapping
    public void create(@RequestBody MessageClass messageClass) {
        messageService.save(messageClass);
    }




    //Delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        messageService.delete(id);
    }
}
