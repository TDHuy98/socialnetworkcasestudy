package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Message;


import java.util.List;

public interface MessageService {
    List<Message> findAll();

    Message save(Message message);

    void delete(Long id);

    Message findById( Long id);
}
