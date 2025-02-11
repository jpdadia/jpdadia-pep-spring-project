package com.example.service;

import com.example.entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.MessageRepository;
import java.util.*;

@Service
public class MessageService {
        @Autowired
        private MessageRepository messageRepository;

        
        public Message createMessage(Message message){
            return messageRepository.save(message);
        }

        public List<Message> getAllMessages(){
            return messageRepository.findAll();
        }

        public List<Message> getMessagesForUser(Integer userId){
            return messageRepository.findByPostedBy(userId);
        }

        public Optional<Message> getMessageById(Integer id){
            return messageRepository.findById(id);
        }

        public int updateMessage(Integer id, String newText){
            return messageRepository.updateMessageTextById(id, newText);
        }

        public int deleteMessage(Integer id){
            return messageRepository.deleteByMessageId(id);
        }
}
