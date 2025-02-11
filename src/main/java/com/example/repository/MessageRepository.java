package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

import java.util.*;

import javax.transaction.Transactional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
    List<Message> findByPostedBy(Integer postedBy);

    @Modifying
    @Transactional
    @Query("UPDATE Message message SET message.messageText =?2 WHERE message.messageId =?1")
    int updateMessageTextById(Integer messageId, String newText);

    @Modifying
    @Transactional
    int deleteByMessageId(Integer messageId);
    
    
}

