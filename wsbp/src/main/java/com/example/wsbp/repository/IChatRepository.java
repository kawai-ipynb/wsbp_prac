package com.example.wsbp.repository;

import com.example.wsbp.data.ChatMessage;

import java.util.List;

public interface IChatRepository {
    void saveChatMessage(String userName, String message);

    List<ChatMessage> getAllChatMessages();

}

