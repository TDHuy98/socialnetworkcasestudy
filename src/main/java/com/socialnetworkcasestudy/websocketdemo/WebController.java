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

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
       simpMessagingTemplate.convertAndSend("/topic/public/"+user.getIdSender(), new Message( user.getMessage(),user.getIdSender(), user.getIdRev()));
        simpMessagingTemplate.convertAndSend("/topic/public/"+ user.getIdRev(), new Message(user.getMessage(),user.getIdSender(), user.getIdRev()));
    }
}
