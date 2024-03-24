package com.example.wsbp.service;

import com.example.wsbp.data.ChatMessage;
import com.example.wsbp.repository.IChatRepository;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

public interface IChatService {
    void saveChatMessage(String userName, String message);


    List<ChatMessage> getAllChatMessages();
}
