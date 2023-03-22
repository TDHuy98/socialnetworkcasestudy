package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Notifications;
import com.socialnetworkcasestudy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoticeRipository extends JpaRepository<Notifications, Long>, JpaSpecificationExecutor<Notifications> {
}
