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
    private String status;
    private String messageType;
    private Long chatId;
    private Reactions reaction;

}

@Data
@NoArgsConstructor
class Reactions{
    private Long senderId;
    private String reaction_type;
}
