package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> showAllMessageById(Long user_id);

    Message findById(Long id);

    Message save(Message message);

    void delete(Long id);


}
