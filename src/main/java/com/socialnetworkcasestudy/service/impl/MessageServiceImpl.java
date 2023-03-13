package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Message;
import com.socialnetworkcasestudy.repository.UserMessageRepository;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    UserMessageRepository userMessageRepository;
    @Override
    public List<Message> findAll() {
        return userMessageRepository.findAll();
    }

    @Override
    public Message save(Message message) {
        return userMessageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        userMessageRepository.deleteById(id);

    }

    @Override
    public Message findById(Long id) {
        return userMessageRepository.findById(id).get();
    }
}
