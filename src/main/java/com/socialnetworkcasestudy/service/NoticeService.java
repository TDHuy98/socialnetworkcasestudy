package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Notifications;

import java.util.List;
import java.util.Optional;

public interface NoticeService {
    List<Notifications> findAll();

    Optional<Notifications> findById(Long id);

    Notifications save(Notifications notifications);

    void delete(Long id);

    List<Notifications> findByIdUser(Long idUser);
}
