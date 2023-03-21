package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.model.Hello;
import com.socialnetworkcasestudy.model.Message;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.model.UserWebSocket;
import com.socialnetworkcasestudy.service.impl.MessageServiceImpl;
import com.socialnetworkcasestudy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessageServiceImpl messageService;

    @MessageMapping("/message")
    public void getting(Message message) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/public/", new Message(
                message.getId(),message.getSource(),message.getTarget(),message.getMessage(),message.getCreatedAt(),message.getCreatedAt()
                )
        );
    }

}
