package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Likes;
import com.socialnetworkcasestudy.model.MessageClass;
import com.socialnetworkcasestudy.model.Notifications;

import java.util.List;

public interface MessageService {

    MessageClass save(MessageClass messageClass);

    void delete(Long id);

    List<MessageClass> findAllByUserId(Long id);
}
