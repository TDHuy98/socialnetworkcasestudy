package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Notifications;
import com.socialnetworkcasestudy.repository.NoticeRipository;
import com.socialnetworkcasestudy.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRipository noticeRipository;


    @Override
    public List<Notifications> findAll() {
        return (List<Notifications>) noticeRipository.findAll();
    }

    @Override
    public Optional<Notifications> findById(Long id) {
        return noticeRipository.findById(id);
    }

    @Override
    public Notifications save(Notifications notifications) {
        return noticeRipository.save(notifications);

    }

    @Override
    public void delete(Long id) {
        noticeRipository.deleteById(id);

    }

    @Override
    public List<Notifications> findByIdUser(Long idUser) {
        List<Notifications> notifications = noticeRipository.findAll();
        List<Notifications> newList = new ArrayList<Notifications>();
        for (int i = 0; i < notifications.size(); i++) {
            if (notifications.get(i).getUserId() == idUser) {
                newList.add(notifications.get(i));
            }
        }
        return newList;
    }

}
