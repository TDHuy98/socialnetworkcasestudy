package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.MessageClass;
import com.socialnetworkcasestudy.model.Notifications;
import com.socialnetworkcasestudy.repository.UserMessageRepository;
import com.socialnetworkcasestudy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    UserMessageRepository userMessageRepository;
    @Override
    public MessageClass save(MessageClass messageClass) {
        return userMessageRepository.save(messageClass);

    }

    @Override
    public void delete(Long id) {
        userMessageRepository.deleteById(id);

    }

    @Override
    public List<MessageClass> findAllByUserId(Long id) {
        List<MessageClass> messages = userMessageRepository.findAll();
        List<MessageClass> newList = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getIdSenders() == id){
                newList.add(messages.get(i));
            }
        }
        return newList;
    }







}
