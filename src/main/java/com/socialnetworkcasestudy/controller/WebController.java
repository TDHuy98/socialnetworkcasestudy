package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Hello;
import com.socialnetworkcasestudy.model.Message;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.model.UserWebSocket;
import com.socialnetworkcasestudy.service.impl.MessageServiceImpl;
import com.socialnetworkcasestudy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessageServiceImpl messageService;

    @MessageMapping("/content")
    public void getting(Message message) throws Exception {
        Message message1 =new Message(
                message.getId(),message.getSource(),message.getTarget(),message.getMessage(),message.getCreatedAt(),message.getCreatedAt()
        );
        message1.setCreatedAt(Instant.from(LocalDate.now()));
        messageService.save(message1);
        simpMessagingTemplate.convertAndSend("/topic/public/", message1
        );
    }




}
