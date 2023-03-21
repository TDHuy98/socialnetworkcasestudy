package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/message")
public class MessageController {
   @Autowired
    MessageServiceImpl messageService;


}
