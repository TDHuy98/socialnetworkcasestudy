package com.socialnetworkcasestudy.websocketdemo;

import com.socialnetworkcasestudy.model.Notifications;
import com.socialnetworkcasestudy.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
       simpMessagingTemplate.convertAndSend("/topic/public/"+user.getIdSender(), new Message( user.getMessage(),user.getIdSender(), user.getIdRev()));
        simpMessagingTemplate.convertAndSend("/topic/public/"+ user.getIdRev(), new Message(user.getMessage(),user.getIdSender(), user.getIdRev()));
    }
    @Autowired
    NoticeService noticeService;


    @GetMapping
    public List<Notifications> showAllUser() {
        return noticeService.findAll();
    }

    //Thêm
    @PostMapping
    public void create(@RequestBody Notifications notifications) {
        noticeService.save(notifications);
    }

    //Hiển thị
    @GetMapping("/{id}")
    public List<Notifications> showNoticationByIdUser(@PathVariable Long id) {
        return noticeService.findByIdUser(id);
    }


    //Delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        noticeService.delete(id);
    }
}
