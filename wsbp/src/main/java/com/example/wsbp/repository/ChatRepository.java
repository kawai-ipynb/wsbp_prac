package com.example.wsbp.repository;

import com.example.wsbp.data.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ChatRepository implements IChatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ChatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveChatMessage(String userName, String message) {
        String sql = "INSERT INTO chat (user_name, msg_body, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, userName, message, Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public List<ChatMessage> getAllChatMessages() {
        String sql = "SELECT * FROM chat ORDER BY created_at DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String userName = rs.getString("user_name");
            String messageBody = rs.getString("msg_body");
            LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
            return new ChatMessage(userName, messageBody, createdAt);
        });
    }
}

