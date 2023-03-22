package com.socialnetworkcasestudy.websocketdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello/{id1}/{id2}")
    public void greeting(User user, @PathVariable("id1") Long id1, @PathVariable("id2") Long id2) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/public"+id1 , new Message(user.getName() +"  " + user.getMessage()));
        simpMessagingTemplate.convertAndSend("/topic/public"+id2 , new Message(user.getName() +"  " + user.getMessage()));
    }
}
