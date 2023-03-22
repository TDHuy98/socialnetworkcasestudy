package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Message;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserMessageRepository;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import com.socialnetworkcasestudy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    UserMessageRepository userMessageRepository;


    @Override
    public List<Message> showAllMessageBySourceId(Long user_id) {
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

    public HashSet<User> ListFriend(Long id) {
        HashSet<User>  friendList = new HashSet<>();

        for (int i = 0; i < showAllMessageBySourceId(id).size(); i++) {
            friendList.add(showAllMessageBySourceId(id).get(i).getTarget());
        }
        return friendList;
    }
}
