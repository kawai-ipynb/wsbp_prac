package com.example.wsbp.service;

import com.example.wsbp.data.ChatMessage;
import com.example.wsbp.repository.ChatRepository;
import com.example.wsbp.repository.IAuthUserRepository;
import com.example.wsbp.repository.IChatRepository;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements IChatService {


    private IChatRepository chatRepos;
    @Autowired
    public ChatService(IChatRepository chatRepos) {
        this.chatRepos = chatRepos;
    }



    @Override
    public void saveChatMessage(String userName, String message) {
        chatRepos.saveChatMessage(userName, message);
    }

    @Override
    public List<ChatMessage> getAllChatMessages() {
        // ChatRepositoryを使用してデータベースからすべてのチャットメッセージを取得する
        return chatRepos.getAllChatMessages();
    }
}

