package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {
    @Query(value = "select * from Message where((Message.source.id = ?1 and Message.target.id = ?2 ) or (Message .target.id=?1 and Message .source.id=?2) ) ",nativeQuery = true)
    List<Message> findMessageBySourceAndTarget(Long source_id,Long target_id);

    @Query(value = "select * from Message where Message .source.id=?1 or Message .target.id=?1",nativeQuery = true)
    List<Message> findAllByUser_Id(Long id);

    @Query(value = "select * from Message where Message .source.id=?1",nativeQuery = true)
    List<Message> findAllBySource_Id(Long id);

}
