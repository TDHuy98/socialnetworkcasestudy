package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Message;
import com.socialnetworkcasestudy.repository.UserMessageRepository;
import com.socialnetworkcasestudy.repository.UserPostRepository;
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
    public List<Message> showAllMessageById(Long user_id) {
        return userMessageRepository.findAllByUser_Id(user_id);
    }

    @Override
    public Message findById(Long id) {
        return userMessageRepository.findById(id).get();
    }

    @Override
    public Message save(Message message) {
        return userMessageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        userMessageRepository.deleteById(id);
    }

    public List<Message> findAllBySourceAndTarget(Long source_id,Long target_id){
        return userMessageRepository.findMessageBySourceAndTarget(source_id,target_id);
    }
}
