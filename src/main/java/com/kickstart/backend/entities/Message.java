package com.kickstart.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class Message {
    @MongoId
    private String id;

    private Long senderId;
    private Long receiverId;

    private String body;
    private LocalDate timestamp;
    private String mediaUrl;
    private Status status;
    private MessageType messageType;
    private Long chatId;
    private Reactions reaction;

    public enum MessageType {
        ONCEVIEW,TEXT, IMAGE, VIDEO, AUDIO
    }
    public enum ReactionType {
        LIKE, DISLIKE, LOVE, ANGRY
    }
    public enum Status {
        SENT, DELIVERED, READ, WAITING
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Reactions {
        private Long senderId;
        private ReactionType reactionType;
    }
}
