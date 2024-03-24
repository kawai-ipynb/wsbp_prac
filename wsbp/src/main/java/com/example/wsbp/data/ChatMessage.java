package com.example.wsbp.data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatMessage implements Serializable {
    private String userName;
    private String messageBody;
    private LocalDateTime createdAt;

    public ChatMessage(String userName, String messageBody, LocalDateTime createdAt) {
        this.userName = userName;
        this.messageBody = messageBody;
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "userName='" + userName + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
