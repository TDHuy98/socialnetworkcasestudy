package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.MessageClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserMessageRepository extends JpaRepository<MessageClass, Long>, JpaSpecificationExecutor<MessageClass> {
}
