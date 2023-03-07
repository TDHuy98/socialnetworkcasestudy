package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserMessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {
}
